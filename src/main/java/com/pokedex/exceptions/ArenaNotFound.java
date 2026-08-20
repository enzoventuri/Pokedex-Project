package com.pokedex.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ArenaNotFound extends RuntimeException {
    public ArenaNotFound(String message) {
        super(message);
    }
}
