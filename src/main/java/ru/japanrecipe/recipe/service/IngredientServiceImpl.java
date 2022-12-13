package ru.japanrecipe.recipe.service;
import org.springframework.stereotype.Service;
import ru.japanrecipe.recipe.model.Ingredient;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
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
}
