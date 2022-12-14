package ru.japanrecipe.recipe.service;
import org.springframework.stereotype.Service;
import ru.japanrecipe.recipe.model.Recipe;
import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class RecipeService {
    private static Integer id;
    private final static Map<Integer, Recipe> recipeMap = new LinkedHashMap<>();
    public void addRecipe(Recipe recipe) {
        recipeMap.put(id++, recipe);
        id++;
    }
    public Recipe getRecipeId(Integer id) {
        return recipeMap.get(id);
    }
}
