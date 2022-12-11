package ru.japanrecipe.recipe.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.japanrecipe.recipe.model.Ingredient;
import ru.japanrecipe.recipe.service.IngredientService;
@RestController
@RequestMapping("/ingredient")
public class IngredientsController {
    private IngredientService ingredientService;
    @GetMapping("/startING")
    public String mainPage() {
        return "Сратовая страничка ингредиентов";
    }
    @GetMapping("/addIngredient")
    public void addRecipe(@RequestParam Ingredient ingredient) {
        this.ingredientService.addIngredient(ingredient);
    }
    @GetMapping("/ingredientId")
    public void getIngredientId(@RequestParam Integer id) {
        this.ingredientService.getIngredient(id);
    }
}
