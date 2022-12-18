package ru.japanrecipe.recipe.service;

import java.io.File;
import java.nio.file.Path;

public interface FilesService {
    boolean saveToFile(String json);

    String readFromFile();

    boolean cleanDataFile();

    //
    File getDataFile();

    //Создание временых файлов
    Path createTempFile(String siffix);
}
