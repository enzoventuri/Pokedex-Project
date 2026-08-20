package com.pokedex.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class GameNotStarted extends RuntimeException {
    public GameNotStarted(String message) {
        super(message);
    }
}
