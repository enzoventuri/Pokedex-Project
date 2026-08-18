package com.pokedex.enums;

public enum Evolutions {
    BASE(0), FIRST(6), MAX(11);

    private int minimumLevels;

    Evolutions(int minimumLevels) {
        this.minimumLevels = minimumLevels;
    }

    public static Evolutions isEvolved(int level){

        Evolutions evolution = BASE;

        for(Evolutions e: Evolutions.values()){
            if(e.getMinimumLevels() <= level){
                evolution = e;
            }
        }

        return evolution;
    }

    public int getMinimumLevels() {
        return minimumLevels;
    }
}
