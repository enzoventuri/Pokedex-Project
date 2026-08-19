package com.pokedex.service;

import com.pokedex.data.DataBase;
import com.pokedex.enums.Items;
import com.pokedex.enums.Trainer;
import com.pokedex.exceptions.*;
import com.pokedex.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.DatabaseMetaData;
import java.util.List;
import java.util.Random;

@Service
public class GameService {

    private PokemonService pokemonService;

    @Autowired
    GameService(PokemonService pokemonService){
        this.pokemonService = pokemonService;
        DataBase.trainer = Trainer.getTrainerFromNumber(new Random().nextInt(2));

        new DataBase();
    }

    public List<Pokemon> getTeam(){

        if(DataBase.pokemonInBag.isEmpty()){

            throw new EmptyTeam("Your team is empty!");

        }

        return DataBase.pokemonInBag;

    }

    public Pokemon healPokemon(int id, double health){

        Pokemon pokemon = pokemonService.checkIfPokemonExists(id);

        return pokemonService.healPokemon(pokemon,health);
    }

    public String moveTrainer(){

        if(DataBase.trainer.name().isBlank()){

            throw new TrainerNotFound("Trainer not found!");

        }

        return DataBase.trainer.name();

    }

    public Items buyItem(Items item) {
        DataBase.items.add(item);
        return item;
    }

    public Items useItem(Items item) {
        List<Items> items = DataBase.items;

        if (!items.contains(item)) {
            throw new NoItemFound("No Item Found!");
        }

        items.remove(item);
        return item;
    }

    public Pokemon capturePokemon() {
        List<Pokemon> pokemons = DataBase.listOfWildPokemons;

        if (pokemons.isEmpty()) {
            throw new NoWildPokemonRemaining("No Wild Pokémon Remaining!");
        }

        if (new Random().nextInt(100) < 50) {
            throw new CaptureFailed("Failed to Capture!");
        }

        Pokemon pokemon = pokemons.get(new Random().nextInt(pokemons.size()));
        DataBase.pokemonInBag.add(pokemon);

        return pokemon;
    }

}
