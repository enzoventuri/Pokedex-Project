package com.pokedex.model;
import com.pokedex.enums.Leader;
import com.pokedex.enums.Trainer;
import com.pokedex.enums.Type;
import jakarta.persistence.*;

@Entity()
@Table(name = "arena")
public class Arena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Trainer trainer;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Leader leader;

    @OneToOne
    @JoinColumn(name = "pokemon_Id")
    private Pokemon enemyPokemons;

    @Column
    private Object champion = null;

    @OneToOne
    @JoinColumn(name = "pokemon_Id")
    private Pokemon someoneDodge = null;

    public Arena(String name,
                 Trainer trainer, Type type, Leader leader, Pokemon pokemons) {
        this.name = name;
        this.trainer = trainer;
        this.type = type;
        this.leader = leader;
        this.enemyPokemons = pokemons;
    }

    public Arena() { }

    public Pokemon getSomeoneDodge() {
        return someoneDodge;
    }

    public void setSomeoneDodge(Pokemon someoneDodge) {
        this.someoneDodge = someoneDodge;
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
