package ru.japanrecipe.recipe.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.japanrecipe.recipe.model.Recipe;
import ru.japanrecipe.recipe.service.impl.RecipeService;
@RestController
@RequestMapping("/recipes")
@Tag(name = "Рецепты", description = "CRUD операции с рецептами")
public class RecipeController {
    private final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    //стартовая страница рецептов
    @GetMapping("/startRec")
    @Operation(summary = "Стартовая страничка", description = "Тут должно быть приветсвие")
    public String mainPage() {
        return "Стартовая страничка рецептов";
    }
    //Добовление рецепт
    @PostMapping("/addRecipe")
    @Operation(summary = "Добавление рецепта", description = "Добовляет рецепт через тело запроса")
    public ResponseEntity<String> addRecipe(@RequestBody Recipe recipe) {
        this.recipeService.addRecipe(recipe);
        return ResponseEntity.ok("Рецепт добавлен");
    }
    //Выводит айди рецепта
    @GetMapping("/recipeId/{recipeId}")
    @Operation(summary = "Вывод рецепта", description = "Выводит рецепт по айди в формате json")
    public void getRecipeId(@RequestParam Integer id) {
        this.recipeService.getRecipeId(id);
    }
    //Изменяет рецепт
    @PutMapping("/update/{recipeId}")
    @Operation(summary = "Изменение рецепт", description = "Изменяет рецепт по айди в формате json")
    public ResponseEntity<String> update(@PathVariable String recipeId, @RequestBody Recipe recipe) {
        recipeService.updateRecipe(Integer.parseInt(recipeId), recipe);
        return  ResponseEntity.ok("Рецепт изменен");
    }
    //Удоляет рецепт
    @DeleteMapping("/delete/{recipeId}")
    @Operation(summary = "Улоление рецепт", description = "Удоляет рецепт по айди")
    public void delete(@PathVariable String recipeId) {
        recipeService.deleteRecipe(Integer.parseInt(recipeId));
    }

}
