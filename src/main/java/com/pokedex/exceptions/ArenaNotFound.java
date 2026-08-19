package com.pokedex.exceptions;

public class ArenaNotFound extends RuntimeException {
    public ArenaNotFound(String message) {
        super(message);
    }
}
