package com.pokedex.enums;

import com.pokedex.exceptions.TrainerNotFound;

import java.lang.annotation.Target;

public enum Trainer {
    ODRAUDE_TREFFEG(0), OZNE_IRUTNEV(1);

    private int id;

    Trainer(int id) {
        this.id = id;
    }

    public static Trainer getTrainerFromName(String name) {
        for (Trainer t : Trainer.values()) {
            if (t.toString().equalsIgnoreCase(name)) {
                return t;
            }
        }

        throw new RuntimeException("Could not find Trainer");
    }

    public static Trainer getTrainerFromNumber(int number){

        for(Trainer t: Trainer.values()){
            if(t.getId() == number){
                return t;
            }
        }
        throw new TrainerNotFound("Trainer not found!");

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
