package ru.japanrecipe.recipe.service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CustomException extends RuntimeException{
    public CustomException(String message) {
        super (message);
    }
}
