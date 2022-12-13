package ru.japanrecipe.recipe.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.japanrecipe.recipe.model.Recipe;
import ru.japanrecipe.recipe.service.RecipeServiceImpl;
@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private RecipeServiceImpl recipeServiceImpl;
    @GetMapping("/startRec")
    public String mainPage() {
        return "Стартовая страничка рецептов";
    }
    @GetMapping("/addRecipe")
    public void addRecipe(@RequestParam Recipe recipe) {
        this.recipeServiceImpl.addRecipe(recipe);
    }
    @GetMapping("/recipeId")
    public void getRecipeId(@RequestParam Integer id) {
        this.recipeServiceImpl.getRecipeId(id);
    }
}
