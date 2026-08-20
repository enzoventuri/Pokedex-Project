package com.pokedex.enums;

import com.pokedex.exceptions.TrainerNotFound;

public enum Type {


    FIRE(1), WATER(2), ELECTRIC(3), STEEL(4), ICE(5), FAIRY(6), DRAGON(7), SHADOW(8), ROCK(9), NORMAL(10), GRASS(11), GHOST(12), PSYCHIC(13), FIGHTING(14), BUG(15), DARK(16), POISON(17), FLYING(18), PLANT(19);

    private int id;

    Type(int id) {
        this.id = id;
    }

    public static Type getTypeFromName(String name) {
        for (Type t : Type.values()) {
            if (t.toString().equalsIgnoreCase(name)) {
                return t;
            }
        }

        throw new RuntimeException("Could not find Type");
    }

    public static Type getTypeFromNumber(int number){

        for(Type t: Type.values()){
            if(t.getId() == number){
                return t;
            }
        }
        throw new TrainerNotFound("Trainer not found!");

    }
    @Override
    public String toString() {
        return super.toString();
    }

    public int getId() {
        return id;
    }
}
