package ru.japanrecipe.recipe.service;
import org.springframework.http.ResponseEntity;
import ru.japanrecipe.recipe.model.Recipe;

import java.io.IOException;

public interface RecipeService {
    void addRecipe(Recipe recipe);

    void getRecipe();

    ResponseEntity<Recipe> getRecipeId(Integer id);

    void updateRecipe(Integer number, Recipe recipe);

    void deleteRecipe(Integer number);

    //Чтение ищ файла
    void readFromFile();
}
