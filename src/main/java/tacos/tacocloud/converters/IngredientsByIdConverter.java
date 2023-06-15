package tacos.tacocloud.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.tacocloud.entities.Ingredient;
import tacos.tacocloud.repositories.IngredientRepository;

@Component
public class IngredientsByIdConverter implements Converter<String, Ingredient> {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientsByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
