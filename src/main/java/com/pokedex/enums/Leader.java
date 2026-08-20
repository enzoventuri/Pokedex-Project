package com.pokedex.enums;

import com.pokedex.exceptions.TrainerNotFound;

public enum Leader {
    RED(0), BLUE(1), ASH(2), BROCK(3), MISTY(4);

    private int id;

    Leader(int id) {
        this.id = id;
    }

    public static Leader getLeaderFromName(String name) {
        for (Leader l : Leader.values()) {
            if (l.toString().equalsIgnoreCase(name)) {
                return l;
            }
        }

        throw new RuntimeException("Could not find Leader");
    }

    public static Leader getLeaderFromNumber(int number){

        for(Leader t: Leader.values()){
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
