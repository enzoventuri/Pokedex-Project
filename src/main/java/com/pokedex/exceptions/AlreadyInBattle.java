package com.pokedex.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AlreadyInBattle extends RuntimeException {
    public AlreadyInBattle(String message) {
        super(message);
    }
}
