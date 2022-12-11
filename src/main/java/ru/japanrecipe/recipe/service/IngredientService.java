package ru.japanrecipe.recipe.service;
import org.springframework.stereotype.Service;
import ru.japanrecipe.recipe.model.Ingredient;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientService {
    private static Integer id;
    private final static Map<Integer, Ingredient> ingredientsMap = new LinkedHashMap<>();
    public void addIngredient(Ingredient ingredients) {
        ingredientsMap.put(id++, ingredients);
        id++;
    }
    public Ingredient getIngredient(Integer id) {
        return ingredientsMap.get(id);
    }
}
