package com.pokedex.model;

import com.pokedex.enums.Leader;
import com.pokedex.enums.Trainer;
import com.pokedex.enums.Type;

import java.util.List;

public class Arena {
    static int nextId = 1;

    private int id;
    private String name;
    private Trainer trainer;
    private Type type;
    private Leader leader;
    private Pokemon enemyPokemons;
    private Object champion = "In battle";

    public Arena(String name,
                 Trainer trainer, Type type, Leader leader, Pokemon pokemons) {
        this.id = nextId++;
        this.name = name;
        this.trainer = trainer;
        this.type = type;
        this.leader = leader;
        this.enemyPokemons = pokemons;
    }

    public Object getChampion() {
        return champion;
    }

    public void setChampion(Object champion) {
        this.champion = champion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public Pokemon getPokemons() {
        return enemyPokemons;
    }

    public void setPokemons(Pokemon pokemons) {
        this.enemyPokemons = pokemons;
    }
}
