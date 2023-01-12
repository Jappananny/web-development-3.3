package ru.japanrecipe.recipe.service;

import java.io.File;
import java.nio.file.Path;

public interface FilesService {
    boolean saveToFile(String json);

    boolean saveRecipesToTxtFile(String txt);

    String readFromFile();

    boolean cleanDataFile();

    void cleanRecipeTxtFile();

    File getDataFile();

    File getTxtFile();

    //Создание временых файлов
    Path createTempFile(String siffix);
}
