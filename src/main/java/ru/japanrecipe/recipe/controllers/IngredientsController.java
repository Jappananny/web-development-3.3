package ru.japanrecipe.recipe.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.japanrecipe.recipe.model.Ingredient;
import ru.japanrecipe.recipe.service.IngredientService;

@RestController
@RequestMapping("/ingredient")
@Tag(name = "Ингредиенты", description = "CRUD операции с ингредиентами")
public class IngredientsController {
    private IngredientService ingredientService;
    //Старовая страница ингредиентов
    @GetMapping("/startIng")
    @Operation(summary = "Стартовая страничка", description = "Тут должно быть приветсвие")
    public String mainPage() {
        return "Сратовая страничка ингредиентов";
    }
    //Добавление ингредиента
    @PostMapping("/")
    @Operation(summary = "Добавление ингредиента", description = "Добовляет ингридиент через тело запроса")
    public ResponseEntity<String> addIngredient(@RequestBody Ingredient ingredient) {
        this.ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok("Ингредиент добавлен");
    }
    //Получение айли ингредиента
    @GetMapping("/{id}")
    @Operation(summary = "Вывод ингридиента", description = "Выводит ингридиент по айди в формате json")
    public void getIngredientId(@RequestParam Integer id) {
        this.ingredientService.getIngredient(id);
    }
    //Изменяет ингридиент
    @PutMapping("/{id}")
    @Operation(summary = "Изменение ингредиента", description = "Изменяет игредиент по айди в формате json")
    public ResponseEntity<String> update(@PathVariable String ingredientId, @RequestBody Ingredient ingredient) {
        ingredientService.updateIngredient(Integer.parseInt(ingredientId), ingredient);
        return  ResponseEntity.ok("Рецепт изменен");
    }
    //Удоляет иншридиент
    @DeleteMapping("/{id}")
    @Operation(summary = "Улоление ингредиента", description = "Удоляет ингредиент по айди")
    public void delete(@PathVariable String ingredientId) {
        ingredientService.deleteIngredient(Integer.parseInt(ingredientId));
    }


}
