package tacos.tacocloud.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.tacocloud.entities.Ingredient;

import java.util.Arrays;
import java.util.List;

@Component
public class IngredientsByIdConverter implements Converter<String, Ingredient> {
    private List<Ingredient> ingredients = List.of(
            new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
            new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
            new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
            new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
            new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
            new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
            new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
            new Ingredient("JACK", "Monterey Jack", Ingredient.Type.CHEESE),
            new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
            new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
    );

    @Override
    public Ingredient convert(String id) {
        return ingredients
                .stream()
                .filter(x -> x.getId().equals(id))
                .findAny()
                .orElse(null);
    }
}
