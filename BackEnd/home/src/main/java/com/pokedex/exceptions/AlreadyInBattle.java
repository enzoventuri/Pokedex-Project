package com.pokedex.exceptions;

public class AlreadyInBattle extends RuntimeException {
    public AlreadyInBattle(String message) {
        super(message);
    }
}
