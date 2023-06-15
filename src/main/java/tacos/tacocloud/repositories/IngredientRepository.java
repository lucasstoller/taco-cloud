package tacos.tacocloud.repositories;

import org.springframework.data.repository.CrudRepository;
import tacos.tacocloud.entities.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {}
