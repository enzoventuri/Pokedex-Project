package com.pokedex.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class PokemonFainted extends RuntimeException {
    public PokemonFainted(String message) {
        super(message);
    }
}
