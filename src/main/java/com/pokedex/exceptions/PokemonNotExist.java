package com.pokedex.exceptions;

public class PokemonNotExist extends RuntimeException {
    public PokemonNotExist(String message) {
        super(message);
    }
}
