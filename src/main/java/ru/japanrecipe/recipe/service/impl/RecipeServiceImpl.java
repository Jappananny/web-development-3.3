package ru.japanrecipe.recipe.service.impl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.japanrecipe.recipe.model.Recipe;
import ru.japanrecipe.recipe.service.FilesService;
import ru.japanrecipe.recipe.service.RecipeService;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class RecipeServiceImpl implements RecipeService {
    final private FilesService filesService;
    private Integer id = counter;
    private static Integer counter = 0;
    private Map<Integer, Recipe> recipeMap = new LinkedHashMap<>();

    public RecipeServiceImpl(FilesService filesService) {
        this.filesService = filesService;
    }
    @PostConstruct
    private void init(){
        readFromFile();
    }
    @Override
    public void addRecipe(Recipe recipe) {
        recipeMap.put(id, recipe);
        counter++;
        saveToFile();
    }
    @Override
    public void getRecipe() {
        for (Recipe recipe : recipeMap.values()) {
            System.out.println(recipe.toString());
        }
    }

    @Override
    public ResponseEntity<Recipe> getRecipeId(Integer id) throws IOException {
        try{
                return ResponseEntity.ok(recipeMap.get(id));
            } catch (Exception e){
            throw new IOException("Такого рецепта нет");
        }
    }
    @Override
    public void updateRecipe(Integer recipeId, Recipe recipe) {
        recipeMap.put(recipeId, recipe);
        saveToFile();
    }
    @Override
    public void deleteRecipe(Integer recipeId) {
        recipeMap.remove(recipeId);
    }
    //Сохранение в фаил
    private void saveToFile(){
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            filesService.saveToFile(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Чтение ищ файла
    private void readFromFile(){
        try {
            String json = filesService.readFromFile();
            recipeMap =  new ObjectMapper().readValue(json, new TypeReference<Map<Integer,Recipe>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
