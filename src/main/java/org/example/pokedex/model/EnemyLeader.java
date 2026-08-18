package org.example.pokedex.model;

import java.util.List;

public class EnemyLeader {

    static private int nextId = 1;
    private int id;
    private String name;
    private List<Pokemon> pokemonList;

    public EnemyLeader(String name, List<Pokemon> pokemonList) {
        this.id = nextId++;
        this.name = name;
        this.pokemonList = pokemonList;
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

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}
