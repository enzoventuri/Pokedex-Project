package com.pokedex.exceptions;

public class PokemonFainted extends RuntimeException {
    public PokemonFainted(String message) {
        super(message);
    }
}
