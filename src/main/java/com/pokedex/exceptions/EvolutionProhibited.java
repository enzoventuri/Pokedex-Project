package com.pokedex.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class EvolutionProhibited extends RuntimeException {
    public EvolutionProhibited(String message) {
        super(message);
    }
}
