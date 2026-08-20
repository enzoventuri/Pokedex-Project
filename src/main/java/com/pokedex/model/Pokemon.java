package com.pokedex.model;
import com.pokedex.enums.Evolutions;
import com.pokedex.enums.Type;
import com.pokedex.exceptions.EvolutionProhibited;
import jakarta.persistence.*;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int level;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Evolutions evolution;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private int number;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type2;

    @Column(nullable = false)
    private double health;

    @Column(nullable = false)
    private double attack;

    @Column(nullable = false)
    private int speed;

    @Column(nullable = false)
    private double defense;

    @Column(nullable = false)
    private String classification;

    public Pokemon(String name, int number, int level, Evolutions evolution, String nickname,
                   Type type, Type type2, double health, double attack,
                   int speed, double defense, String classification) {
        this.name = name;
        this.level = level;
        this.evolution = evolution;
        this.nickname = nickname;
        this.number = number;
        this.type = type;
        this.type2 = type2;
        this.health = health;
        this.attack = attack;
        this.speed = speed;
        this.defense = defense;
        this.classification = classification;
    }

    public Pokemon() {}

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Evolutions getEvolution() {
        return evolution;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType2() {
        return type2;
    }

    public void setType2(Type type2) {
        this.type2 = type2;
    }

    public double getHealth() {
        return health;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }


    public String evolvePokemon() {
        int level = this.evolution.getMinimumLevels();
        Evolutions evolution = Evolutions.isEvolved(this.getLevel());
        if(this.level > level && this.evolution != evolution){

            this.evolution = evolution;

            return this.name + " has evolved to " + this.evolution;

        }

        throw new EvolutionProhibited("Your pokemon doesn´t have enough levels to evolve");

    }

    public String addLevel(int level) {
        this.level += level;
        return this.name + " has leveled up " + level + " levels!";
    }


    public boolean changeHealth(double health) {

        if(this.health <= 0){

            return false;

        }

        this.health += health;

        if(this.health < 0){
            this.health = 0;
        }

        return true;
    }

    public String movePokemon(){
        return this.name + " has moved!";
    }

    public String faintPokemon(){
        return this.name + " has fainted!";
    }

    public String dodgePokemon(){
        return this.name + " has dodge the attack!";
    }

    public String flee() {
        return this.name + " has fleeded the battle";
    }

    public double attack() {
        return this.attack;
    }


}
