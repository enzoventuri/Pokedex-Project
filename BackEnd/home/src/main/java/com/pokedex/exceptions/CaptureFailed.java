package com.pokedex.exceptions;

public class CaptureFailed extends RuntimeException {
    public CaptureFailed(String message) {
        super(message);
    }
}
