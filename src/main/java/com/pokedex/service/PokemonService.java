package com.pokedex.service;
import com.pokedex.data.DataBase;
import com.pokedex.enums.Evolutions;
import com.pokedex.enums.Type;
import com.pokedex.exceptions.PokemonNotExist;
import com.pokedex.model.Pokemon;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * Service responsible for Pokemon business rules
 *
 * @author Eduardo Geffert da Silva and Enzo Venturi
 * @since v0.1
 */
@Tag(
        name = "Pokemon Service",
        description = "Service responsible for checking specific Pokemon rules for methods"
)
@Service
public class PokemonService {

    public PokemonService() {
      Pokemon pokemon4 = DataBase.listOfWildPokemons.get(new Random().nextInt(DataBase.listOfWildPokemons.size()));
      DataBase.activePokemon = pokemon4;
    }

    public Pokemon getActivePokemon(int id){
        if(DataBase.activePokemon.getId() != id){
            throw new PokemonNotExist("Pokemon is not on the active spot!");
        }

        return DataBase.activePokemon;

    }

    public Pokemon checkIfPokemonExists(int id){
        for (Pokemon p : DataBase.pokemonInBag) {
            if (p.getId() == id) {
                return p;
            }
        }

        throw new PokemonNotExist("Pokemon not exist or not active");
    }

    public String levelUp(Pokemon pokemon, int levelsToBeAdded) {
        if (pokemon == null) {
            throw new PokemonNotExist("Invalid Pokemon!");
        }

        return pokemon.addLevel(levelsToBeAdded);
    }

    public String evolvePokemon(Pokemon pokemon){

        return pokemon.evolvePokemon();
    }

    public List<Pokemon> getPokemons() {
        return DataBase.pokemonInBag;
    }

    public Pokemon healPokemon(Pokemon pokemon, double health){

        pokemon.changeHealth(health);

        return pokemon;
    }
}
