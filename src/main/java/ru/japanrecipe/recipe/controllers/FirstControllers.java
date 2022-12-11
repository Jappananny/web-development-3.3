package ru.japanrecipe.recipe.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstControllers {
    @GetMapping("/")
    public String startPage(){
        return "やめてください";
    }
    @GetMapping("/main")
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
