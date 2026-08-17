package com.pokedex.data;

import com.pokedex.enums.Items;
import com.pokedex.model.Pokemon;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DataBase {

    public static List<Pokemon> pokemonInBag = new CopyOnWriteArrayList<>();
    public static List<Items> items;
    public static Pokemon activePokemon;
}
