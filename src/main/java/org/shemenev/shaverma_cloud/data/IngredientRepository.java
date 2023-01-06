package org.shemenev.shaverma_cloud.data;


import org.shemenev.shaverma_cloud.shaverma.Ingredient;
import java.util.Optional;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);

}
