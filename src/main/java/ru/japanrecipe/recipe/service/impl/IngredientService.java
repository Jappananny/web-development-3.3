package ru.japanrecipe.recipe.service.impl;
import org.springframework.stereotype.Service;
import ru.japanrecipe.recipe.model.Ingredient;
import ru.japanrecipe.recipe.service.IngredientServiceInterface;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientService implements IngredientServiceInterface {
    private static Integer id;
    private final static Map<Integer, Ingredient> ingredientsMap = new LinkedHashMap<>();
    @Override
    public void addIngredient(Ingredient ingredients) {
        ingredientsMap.put(id++, ingredients);
        id++;
    }
    @Override
    public Ingredient getIngredient(Integer id) {
        return ingredientsMap.get(id);
    }
    @Override
    public void updateIngredient(Integer ingredientId, Ingredient ingredient) {
        ingredientsMap.put(ingredientId, ingredient);
    }
    @Override
    public void deleteIngredient(Integer ingredientId) {
        ingredientsMap.remove(ingredientId);
    }
}
