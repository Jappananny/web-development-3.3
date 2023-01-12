package ru.japanrecipe.recipe.service.impl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.japanrecipe.recipe.service.CustomException;
import ru.japanrecipe.recipe.service.FilesService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {
    @Value("${path.to.data.file}")
    private String dataFilePath;
    @Value("${name.of.data.file}")
    private String dataFileName;
    @Value("${path.to.recipesTXT.file}")
    private String recipesTxtFilePath;

    @Value("${name.of.recipesTXT.file}")
    private String recipeTxtFileName;
    //Сохранение в фаил
    @Override
    public boolean saveToFile(String json){
        try {
            cleanDataFile();
            Files.writeString(Path.of(dataFilePath, dataFileName),json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean saveRecipesToTxtFile(String txt) {
        try {
            cleanRecipeTxtFile();
            Files.writeString(Path.of(recipesTxtFilePath, recipeTxtFileName), txt);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    //Чтение файла
    @Override
    public String readFromFile(){
        try {
            return Files.readString(Path.of(dataFilePath, dataFileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileRecipeExceptionimpl("Файлов для чтения не найдено");
        }
    }
    //Удаление файла
    @Override
    public boolean cleanDataFile(){
        try {
            Path path = Path.of(dataFilePath, dataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public void cleanRecipeTxtFile(){
        try {
            Path path = Path.of(recipesTxtFilePath, recipeTxtFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Получение файла
    @Override
    public File getDataFile(){
        return new File(dataFilePath + "/" + dataFileName);
    }
    @Override
    public File getTxtFile() {
        if (Files.exists(Path.of(recipesTxtFilePath, recipeTxtFileName))) {
            return new File(recipesTxtFilePath + "/" + recipeTxtFileName);
        }
        return null;
    }
    //Создание временых файлов
    @Override
    public Path createTempFile(String siffix){
        try {
            return Files.createTempFile(Path.of(dataFilePath),"tempFile", siffix);
        } catch (IOException e) {
            throw new FileRecipeExceptionimpl("Временный фаил не создался");
        }
    }
}
