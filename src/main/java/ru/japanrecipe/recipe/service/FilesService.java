package ru.japanrecipe.recipe.service;

public interface FilesService {
    boolean saveToFile(String json);

    String readFromFile();

    boolean cleanDataFile();
}
