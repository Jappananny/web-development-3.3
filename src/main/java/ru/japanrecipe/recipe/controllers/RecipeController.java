package ru.japanrecipe.recipe.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.japanrecipe.recipe.model.Recipe;
import ru.japanrecipe.recipe.service.impl.RecipeServiceImpl;
@RestController
@RequestMapping("/recipes")
@Tag(name = "Рецепты", description = "CRUD операции с рецептами")
public class RecipeController {
    private final RecipeServiceImpl recipeServiceImpl;
    public RecipeController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
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
        this.recipeServiceImpl.addRecipe(recipe);
        return ResponseEntity.ok("Рецепт добавлен");
    }
    //Выводит айди рецепта
    @GetMapping("/recipeId/{recipeId}")
    @Operation(summary = "Вывод рецепта", description = "Выводит рецепт по айди в формате json")
    public void getRecipeId(@RequestParam Integer id) {
        this.recipeServiceImpl.getRecipeId(id);
    }
    //Изменяет рецепт
    @PutMapping("/update/{recipeId}")
    @Operation(summary = "Изменение рецепт", description = "Изменяет рецепт по айди в формате json")
    public ResponseEntity<String> update(@PathVariable String recipeId, @RequestBody Recipe recipe) {
        recipeServiceImpl.updateRecipe(Integer.parseInt(recipeId), recipe);
        return  ResponseEntity.ok("Рецепт изменен");
    }
    //Удоляет рецепт
    @DeleteMapping("/delete/{recipeId}")
    @Operation(summary = "Улоление рецепт", description = "Удоляет рецепт по айди")
    public void delete(@PathVariable String recipeId) {
        recipeServiceImpl.deleteRecipe(Integer.parseInt(recipeId));
    }

}
