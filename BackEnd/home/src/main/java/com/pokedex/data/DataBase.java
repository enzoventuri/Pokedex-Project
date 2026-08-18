package com.pokedex.data;

import com.pokedex.enums.Evolutions;
import com.pokedex.enums.Items;
import com.pokedex.enums.Trainer;
import com.pokedex.enums.Type;
import com.pokedex.model.Arena;
import com.pokedex.model.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DataBase {

    public static List<Pokemon> pokemonInBag = new CopyOnWriteArrayList<>();
    public static List<Items> items = new ArrayList<>();
    public static Pokemon activePokemon;
    public static Trainer trainer;
    public static List<Pokemon> listOfWildPokemons = new ArrayList<>();
    public static Arena arena = null;
    private static boolean isCreated = false;

    public DataBase() {
        if(isCreated == true){
            return;
        }
        listOfWildPokemons.add(new Pokemon("Charizard", 6, 50, Evolutions.MAX, "Flameburst",
                Type.FIRE, Type.FLYING, 78.0, 84.0, 100, 78.0, "Flame Pokémon"));

        listOfWildPokemons.add(new Pokemon("Gengar", 94, 45, Evolutions.MAX, "Shadow",
                Type.DARK, Type.SHADOW, 60.0, 65.0, 110, 60.0, "Shadow Pokémon"));

        listOfWildPokemons.add(new Pokemon("Larvitar", 246, 15, Evolutions.FIRST, "Small Titan",
                Type.ROCK, null, 78.0, 40.0, 100, 78.0, "Rock Pokémon"));

        listOfWildPokemons.add(new Pokemon("Gardevoir", 147, 15, Evolutions.MAX, "Garden",
                Type.PLANT, Type.PSYCHIC, 78.0, 40.0, 100, 78.0, "Psychic Pokémon"));

        listOfWildPokemons.add(new Pokemon("Dragonite", 149, 60, Evolutions.MAX, "Tempest",
            Type.DRAGON, Type.FLYING, 91.0, 34.0, 80, 95.0, "Dragon Pokémon"));

        listOfWildPokemons.add(new Pokemon("Pikachu", 1, 0, Evolutions.BASE,"Pika",
                Type.ELECTRIC, null,100, 20, 5, 70, "Pikachu - Eletric Mouse"));
        listOfWildPokemons.add(new Pokemon("Pikach", 2, 0, Evolutions.BASE, "Pika",
                Type.DRAGON, null,60, 22, 57, 170, "Pikach - Eletri Mouse"));
        listOfWildPokemons.add(new Pokemon("Pikac", 3, 0, Evolutions.BASE, "Pika",
                Type.FAIRY, null,50, 21, 51, 720, "Pikac - Eletr Mouse"));
        listOfWildPokemons.add(new Pokemon("Pika", 4, 0, Evolutions.BASE, "Pika",
                Type.FIRE, null,80, 20, 53, 7110, "Pika - Elet Mouse"));
        listOfWildPokemons.add(new Pokemon("Pik", 5, 0, Evolutions.BASE, "Pika",
                Type.GRASS, null,700, 20, 55, 720, "Pik - Ele Mouse"));

        isCreated = true;
    }

}
