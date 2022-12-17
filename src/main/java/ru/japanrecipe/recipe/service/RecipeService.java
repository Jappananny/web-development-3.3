package ru.japanrecipe.recipe.service;
import org.springframework.http.ResponseEntity;
import ru.japanrecipe.recipe.model.Recipe;

import java.io.IOException;

public interface RecipeService {
    void addRecipe(Recipe recipe);

    ResponseEntity<Recipe> getRecipeId(Integer id) throws IOException;

    void getRecipe();


    void updateRecipe(Integer number, Recipe recipe);

    void deleteRecipe(Integer number);

}
