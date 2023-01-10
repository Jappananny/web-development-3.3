package ru.japanrecipe.recipe.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.japanrecipe.recipe.model.Recipe;
import ru.japanrecipe.recipe.service.CustomException;
import ru.japanrecipe.recipe.service.RecipeService;
import ru.japanrecipe.recipe.service.impl.RecipeExceptionimpl;
import ru.japanrecipe.recipe.service.impl.RecipeServiceImpl;

import java.io.IOException;
@RestController
@RequestMapping("/recipes")
@Tag(name = "Рецепты", description = "CRUD операции с рецептами")
public class RecipeController {
    private final RecipeService recipeService;
    public RecipeController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeService = recipeServiceImpl;
    }
    //стартовая страница рецептов
    @GetMapping("/startRec")
    @Operation(summary = "Стартовая страничка", description = "Тут должно быть приветсвие")
    public String mainPage() {
        return "Стартовая страничка рецептов";
    }
    //Добовление рецепт
    @PostMapping("/")
    @Operation(summary = "Добавление рецепта", description = "Добовляет рецепт через тело запроса")
    public ResponseEntity<String> addRecipe(@RequestBody Recipe recipe) {
        this.recipeService.addRecipe(recipe);
        return ResponseEntity.ok("Рецепт добавлен");
    }
    //Выводит айди рецепта
    @GetMapping("/{id}")
    @Operation(summary = "Вывод рецепта", description = "Выводит рецепт по айди в формате json")
    public ResponseEntity<Recipe> getRecipeId(@PathVariable Integer id) {
        try {
            return recipeService.getRecipeId(id);
        } catch (RecipeExceptionimpl e) {
            throw new RecipeExceptionimpl("Рецепта нет");
        }
    }
    //Изменяет рецепт
    @PutMapping("/{id}")
    @Operation(summary = "Изменение рецепт", description = "Изменяет рецепт по айди в формате json")
    public ResponseEntity<String> update(@PathVariable String recipeId, @RequestBody Recipe recipe) {
        recipeService.updateRecipe(Integer.parseInt(recipeId), recipe);
        return  ResponseEntity.ok("Рецепт изменен");
    }
    //Удоляет рецепт
    @DeleteMapping("/{id}")
    @Operation(summary = "Улоление рецепт", description = "Удоляет рецепт по айди")
    public void delete(@PathVariable String recipeId) {
        recipeService.deleteRecipe(Integer.parseInt(recipeId));
    }

}
