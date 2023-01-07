package ru.japanrecipe.recipe.service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CustomExeprion extends RuntimeException{
    public CustomExeprion(String message) {
        super (message);
    }
}
