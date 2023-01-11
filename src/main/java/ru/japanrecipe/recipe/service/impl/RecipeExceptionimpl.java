package ru.japanrecipe.recipe.service.impl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.japanrecipe.recipe.service.CustomException;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class RecipeExceptionimpl extends CustomException {
    public RecipeExceptionimpl(String message) {
        super(message);
    }
}
