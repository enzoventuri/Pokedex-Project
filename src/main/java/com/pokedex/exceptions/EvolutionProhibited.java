package com.pokedex.exceptions;

public class EvolutionProhibited extends RuntimeException {
    public EvolutionProhibited(String message) {
        super(message);
    }
}
