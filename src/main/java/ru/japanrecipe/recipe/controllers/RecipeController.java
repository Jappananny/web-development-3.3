package ru.japanrecipe.recipe.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.japanrecipe.recipe.model.Recipe;
import ru.japanrecipe.recipe.service.impl.RecipeService;
@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    //стартовая страница рецептов
    @GetMapping("/startRec")
    public String mainPage() {
        return "Стартовая страничка рецептов";
    }
    //Добовление рецепт
    @PostMapping("/addRecipe")
    public ResponseEntity<String> addRecipe(@RequestBody Recipe recipe) {
        this.recipeService.addRecipe(recipe);
        return ResponseEntity.ok("Рецепт добавлен");
    }
    //Выводит айди рецепта
    @GetMapping("/recipeId")
    public void getRecipeId(@RequestParam Integer id) {
        this.recipeService.getRecipeId(id);
    }
    //Изменяет рецепт
    @PutMapping("/update/{recipeId}")
    public ResponseEntity<String> update(@PathVariable String recipeId, @RequestBody Recipe recipe) {
        recipeService.updateRecipe(Integer.parseInt(recipeId), recipe);
        return  ResponseEntity.ok("Рецепт изменен");
    }
    //Удоляет рецепт
    @DeleteMapping("/delete/{recipeId}")
    public void delete(@PathVariable String recipeId) {
        recipeService.deleteRecipe(Integer.parseInt(recipeId));
    }
    //Вывод всех рецептов
    @GetMapping(value = "/allRecipes")
    @ResponseBody
    public String allRecipes(@PathVariable Integer id, @PathVariable String name) {
        return "ID: " + id + ", Название: " + name;
    }
}
