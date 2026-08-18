package com.pokedex.exceptions;

public class NoItemFound extends RuntimeException {
    public NoItemFound(String message) {
        super(message);
    }
}
