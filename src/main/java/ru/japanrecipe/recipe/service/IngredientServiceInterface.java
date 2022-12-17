package ru.japanrecipe.recipe.service;

import org.apache.tomcat.util.buf.StringUtils;
import ru.japanrecipe.recipe.model.Ingredient;

public interface IngredientServiceInterface {
    void addIngredient(Ingredient ingredients);

    Ingredient getIngredient(Integer id);

    void updateIngredient(Integer ingredientId, Ingredient ingredient);

    void deleteIngredient(Integer ingredientId);


}
