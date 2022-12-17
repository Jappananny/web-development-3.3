package ru.japanrecipe.recipe.service.impl;
import org.springframework.stereotype.Service;
import ru.japanrecipe.recipe.model.Recipe;
import ru.japanrecipe.recipe.service.RecipeService;
import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class RecipeServiceImpl implements RecipeService {
    private static Integer id = 0;
    private final Map<Integer, Recipe> recipeMap = new LinkedHashMap<>();
    @Override
    public void addRecipe(Recipe recipe) {
        recipeMap.put(id, recipe);
        id++;
    }
    @Override
    public Recipe getRecipeId(Integer id) {
        return recipeMap.get(id);
    }
    @Override
    public void updateRecipe(Integer recipeId, Recipe recipe) {
        recipeMap.put(recipeId, recipe);
    }
    @Override
    public void deleteRecipe(Integer recipeId) {
        recipeMap.remove(recipeId);
    }
}
