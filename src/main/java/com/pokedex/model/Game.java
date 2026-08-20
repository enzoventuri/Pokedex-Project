package com.pokedex.model;
import com.pokedex.enums.Items;
import com.pokedex.enums.Trainer;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pokemon_id")
    private ArrayList<Pokemon> pokemonInBag = new ArrayList<>();

    @ElementCollection(targetClass = Items.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "items_bag",
            joinColumns = @JoinColumn(name = "item_id")
    )
    @Column(name = "item")
    private ArrayList<Items> items = new ArrayList<>();

    @OneToOne
    private Pokemon activePokemon;

    @Enumerated(EnumType.STRING)
    @Column
    private Trainer trainer;

    @OneToOne()
    @JoinColumn(name = "arena_id")
    private Arena arena = null;

    @Column
    private boolean isFinished = false;

    public Game() {}

    public Game(ArrayList<Pokemon> pokemonInBag, ArrayList<Items> items,
                Pokemon activePokemon, Trainer trainer, Arena arena, boolean isFinished) {
        this.pokemonInBag = pokemonInBag;
        this.items = items;
        this.activePokemon = activePokemon;
        this.trainer = trainer;
        this.arena = arena;
        this.isFinished = isFinished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Pokemon> getPokemonInBag() {
        return pokemonInBag;
    }

    public void setPokemonInBag(ArrayList<Pokemon> pokemonInBag) {
        this.pokemonInBag = pokemonInBag;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public Pokemon getActivePokemon() {
        return activePokemon;
    }

    public void setActivePokemon(Pokemon activePokemon) {
        this.activePokemon = activePokemon;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
