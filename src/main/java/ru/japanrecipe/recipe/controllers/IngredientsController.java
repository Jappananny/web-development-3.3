package ru.japanrecipe.recipe.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.japanrecipe.recipe.model.Ingredient;
import ru.japanrecipe.recipe.service.impl.IngredientService;
@RestController
@RequestMapping("/ingredient")
public class IngredientsController {
    private final IngredientService ingredientService;

    public IngredientsController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    //Старовая страница ингредиентов
    @GetMapping("/startIng")
    public String mainPage() {
        return "Сратовая страничка ингредиентов";
    }
    //Добавление ингрелиента
    @PostMapping("/addIngredient")
    public ResponseEntity<String> addIngredient(@RequestBody Ingredient ingredient) {
        this.ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok("Ингредиент добавлен");
    }
    //Получение айли ингредиента
    @GetMapping("/ingredientId")
    public void getIngredientId(@RequestParam Integer id) {
        this.ingredientService.getIngredient(id);
    }
    //Изменяет ингридиент
    @PutMapping("/update/{ingredientId}")
    public ResponseEntity<String> update(@PathVariable String ingredientId, @RequestBody Ingredient ingredient) {
        ingredientService.updateIngredient(Integer.parseInt(ingredientId), ingredient);
        return  ResponseEntity.ok("Рецепт изменен");
    }
    //Удоляет иншридиент
    @DeleteMapping("/delete/{ingredientId}")
    public void delete(@PathVariable String ingredientId) {
        ingredientService.deleteIngredient(Integer.parseInt(ingredientId));
    }
    //Вывод всех ингредиентов
    @GetMapping(value = "/allIngredients")
    @ResponseBody
    public String allIngedients(@PathVariable Integer id, @PathVariable String name) {
        return "ID: " + id + ", Название: " + name;
    }
}
