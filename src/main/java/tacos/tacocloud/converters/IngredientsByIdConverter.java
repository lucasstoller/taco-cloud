package tacos.tacocloud.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.tacocloud.entities.Ingredient;
import tacos.tacocloud.repositories.JdbcIngredientRepository;

@Component
public class IngredientsByIdConverter implements Converter<String, Ingredient> {
    private final JdbcIngredientRepository jdbcIngredientRepository;

    @Autowired
    public IngredientsByIdConverter(JdbcIngredientRepository jdbcIngredientRepository) {
        this.jdbcIngredientRepository = jdbcIngredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        return  jdbcIngredientRepository.findById(id);
    }
}
