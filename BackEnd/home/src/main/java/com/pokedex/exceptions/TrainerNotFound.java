package com.pokedex.exceptions;

public class TrainerNotFound extends RuntimeException {
    public TrainerNotFound(String message) {
        super(message);
    }
}
