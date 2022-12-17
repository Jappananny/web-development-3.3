package ru.japanrecipe.recipe.service.impl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.japanrecipe.recipe.service.FilesService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiceImpl implements FilesService {
    @Value("${path.to.data.file}")
    private String dataFilePath;
    @Value("${name.of.data.file}")
    private String dataFileName;
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
    //Чтение файла
    @Override
    public String readFromFile(){
        try {
            return Files.readString(Path.of(dataFilePath, dataFileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
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

}
