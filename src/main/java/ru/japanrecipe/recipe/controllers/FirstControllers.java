package ru.japanrecipe.recipe.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Стартовый контролер", description = "Выдает только инфо по проэкту")
public class FirstControllers {
    @GetMapping("/")
    @Operation(summary = "Приветствие", description = "Должно возврашять текст и картинку, когда-нибудь")
    public String startPage(){
        return "やめてください";
    }
    @GetMapping("/main")
    @Operation(summary = "Описание проэкта", description = "Выводит инфо по проэкту, надо еще узнать как это делать не в 1 строку!!!")
    public String mainPage(){
        String projectName = "Книга рецептов Японии";
        String projectFunctions = "Выводит рецепты по запросу";
        String projectTechnology = "Java Web, Spring, Maven";
        String projectLanguage = "Java";

        return projectName + ". \n" +
                projectFunctions + ". \n" +
                projectTechnology + ". \n" +
                projectLanguage + ".";
    }
    @GetMapping("/info")
    @Operation(summary = "Инфо по создателю этого говно-кода", description = "Выводит еще информацию(больше не нцжной " +
            "инфо, \nтак же надо еще узнать как это делать не в 1 строку!!!)")
    public String pageInfo(){
        String studentName = "Королёв Артем";
        String projectName = "Книга рецептов Японии";
        String createDate = "03.12.2022";
        String description = "Сборник традиционых Японских блюд";

        return studentName + ". \n" +
                projectName + ". \n" +
                createDate + ". \n" +
                description + ".";
    }
}
