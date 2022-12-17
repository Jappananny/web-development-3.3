package ru.japanrecipe.recipe.service;
import ru.japanrecipe.recipe.model.Recipe;

public interface RecipeService {
    void addRecipe(Recipe recipe);

    Recipe getRecipeId(Integer id);

    void updateRecipe(Integer number, Recipe recipe);

    void deleteRecipe(Integer number);

}
