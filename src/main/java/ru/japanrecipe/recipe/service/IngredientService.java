package ru.japanrecipe.recipe.service;

import ru.japanrecipe.recipe.model.Ingredient;

public interface IngredientService {
    void addIngredient(Ingredient ingredients);

    Ingredient getIngredient(Integer id);

    void updateIngredient(Integer ingredientId, Ingredient ingredient);

    void deleteIngredient(Integer ingredientId);


}
