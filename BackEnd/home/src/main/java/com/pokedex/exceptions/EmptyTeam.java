package com.pokedex.exceptions;

public class EmptyTeam extends RuntimeException {
    public EmptyTeam(String message) {
        super(message);
    }
}
