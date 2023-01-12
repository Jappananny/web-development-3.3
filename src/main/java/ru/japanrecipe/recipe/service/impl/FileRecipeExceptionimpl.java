package ru.japanrecipe.recipe.service.impl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.japanrecipe.recipe.service.CustomException;
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class FileRecipeExceptionimpl extends CustomException {
    public FileRecipeExceptionimpl(String message) {
        super(message);
    }
}
