package com.pokedex.model;

import com.pokedex.enums.Leader;
import com.pokedex.enums.Trainer;

public class Battle {

    private Pokemon activePokemon;
    private Pokemon pokemon2;
    private Trainer trainer;
    private Leader leader;

    public Battle(Pokemon activePokemon, Pokemon pokemon2, Trainer trainer) {
        this.activePokemon = activePokemon;
        this.pokemon2 = pokemon2;
        this.trainer = trainer;
    }

    public Battle(Pokemon activePokemon, Pokemon pokemon2, Trainer trainer, Leader leader) {
        this.activePokemon = activePokemon;
        this.pokemon2 = pokemon2;
        this.trainer = trainer;
        this.leader = leader;
    }

    public Pokemon getActivePokemon() {
        return activePokemon;
    }

    public void setActivePokemon(Pokemon activePokemon) {
        this.activePokemon = activePokemon;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
