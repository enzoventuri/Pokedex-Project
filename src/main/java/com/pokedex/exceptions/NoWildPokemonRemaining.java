package com.pokedex.exceptions;

public class NoWildPokemonRemaining extends RuntimeException {
    public NoWildPokemonRemaining(String message) {
        super(message);
    }
}
