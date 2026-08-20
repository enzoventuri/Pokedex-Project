package com.pokedex.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class NoWildPokemonRemaining extends RuntimeException {
    public NoWildPokemonRemaining(String message) {
        super(message);
    }
}
