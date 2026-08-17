package com.pokedex.enums;

public enum Trainer {
    ASH, GEFFERT, ENZO;

    public static Trainer getTrainerFromName(String name) {
        for (Trainer t : Trainer.values()) {
            if (t.toString().equalsIgnoreCase(name)) {
                return t;
            }
        }

        throw new RuntimeException("Could not find Trainer");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
