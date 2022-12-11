package ru.japanrecipe.recipe.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@Data
public class Recipe {
    private String name;
    private int time;
    private List<Ingredient> ingredientList = new ArrayList<>();
    private LinkedList<String> steps = new LinkedList<>();
}

