package ru.japanrecipe.recipe.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.japanrecipe.recipe.model.Ingredient;
import ru.japanrecipe.recipe.service.IngredientServiceImpl;
@RestController
@RequestMapping("/ingredient")
public class IngredientsController {
    private IngredientServiceImpl ingredientServiceImpl;
    @GetMapping("/startIng")
    public String mainPage() {
        return "Сратовая страничка ингредиентов";
    }
    @GetMapping("/addIngredient")
    public void addRecipe(@RequestParam Ingredient ingredient) {
        this.ingredientServiceImpl.addIngredient(ingredient);
    }
    @GetMapping("/ingredientId")
    public void getIngredientId(@RequestParam Integer id) {
        this.ingredientServiceImpl.getIngredient(id);
    }
}
