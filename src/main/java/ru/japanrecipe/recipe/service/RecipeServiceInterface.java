package ru.japanrecipe.recipe.service;

import ru.japanrecipe.recipe.model.Recipe;

public interface RecipeServiceInterface {
    void addRecipe(Recipe recipe);

    Recipe getRecipeId(Integer id);
}
