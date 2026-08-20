package com.pokedex.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)

public class EmptyTeam extends RuntimeException {
    public EmptyTeam(String message) {
        super(message);
    }
}
