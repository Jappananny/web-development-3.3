package ru.japanrecipe.recipe.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    private String name;
    private int weght;
    private String measureUnit;
}
