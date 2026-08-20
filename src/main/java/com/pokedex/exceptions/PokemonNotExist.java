package com.pokedex.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PokemonNotExist extends RuntimeException {
    public PokemonNotExist(String message) {
        super(message);
    }
}
