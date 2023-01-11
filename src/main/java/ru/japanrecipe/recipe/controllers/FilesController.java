package ru.japanrecipe.recipe.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.japanrecipe.recipe.service.FilesService;
import java.io.*;
@RestController
@RequestMapping("/files")
@Tag(name = "Работа с файлами", description = "CRUD операции с файлами")
public class FilesController {
    private final FilesService filesService;


    public FilesController(FilesService filesService) {
        this.filesService = filesService;
    }
    @GetMapping("recipeExportAsTxt")
    @Operation(summary = "Сохранение файла с рецептами на компьютер пользователя в формате txt")
    public ResponseEntity<InputStreamResource> downloadRecipesAsTxt() throws FileNotFoundException {
        File file = filesService.getTxtFile();
        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().
                    contentLength(file.length()).
                    contentType(MediaType.TEXT_PLAIN).
                    header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Recipes.txt\"").
                    body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //Экспорт файла
    @GetMapping(value = "/export")
    @Operation(summary = "Экспорт файла", description = "Скачивания файла в формате json")
    public ResponseEntity<InputStreamResource> downloadDataFile() throws FileNotFoundException {
        File file = filesService.getDataFile();
        if (file.exists()){
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION,"attachment: filename=\"RecipeData.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
    //Импорт файла
    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(summary = "Импорт файла", description = "Загрузка файла в формате json")
    public ResponseEntity<Void> uploadDataFile(@RequestParam MultipartFile file) {
        filesService.cleanDataFile();
        File dataFile = filesService.getDataFile();
        //Метод загрузки с библиотекой
        try (FileOutputStream fos = new FileOutputStream(dataFile)) {
            IOUtils.copy(file.getInputStream(), fos);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
