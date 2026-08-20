package com.pokedex.service;
import com.pokedex.exceptions.NoWildPokemonRemaining;
import com.pokedex.exceptions.PokemonNotExist;
import com.pokedex.model.Pokemon;
import com.pokedex.repository.PokemonRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    private PokemonRepository repository;

    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Pokemon> getWildPokemons() {
        List<Pokemon> pokemons = repository.findAll();
        ArrayList<Pokemon> pokemonsArray = new ArrayList<>(pokemons);

        if (pokemonsArray.isEmpty()) {
            throw new NoWildPokemonRemaining("No Pokemons Remaining!");
        }

        return pokemonsArray;
    }


    public PokemonRepository getActivePokemon(int id){
        if(DataBase.activePokemon.getId() != id){
            throw new PokemonNotExist("Pokemon is not on the active spot!");
        }

        return DataBase.activePokemon;

    }

    public PokemonRepository checkIfPokemonExists(int id){
        for (PokemonRepository p : DataBase.pokemonInBag) {
            if (p.getId() == id) {
                return p;
            }
        }

        throw new PokemonNotExist("Pokemon not exist or not active");
    }

    public String levelUp(PokemonRepository pokemon, int levelsToBeAdded) {
        if (pokemon == null) {
            throw new PokemonNotExist("Invalid Pokemon!");
        }

        return pokemon.addLevel(levelsToBeAdded);
    }

    public String evolvePokemon(PokemonRepository pokemon){

        return pokemon.evolvePokemon();
    }

    public List<PokemonRepository> getPokemons() {
        return DataBase.pokemonInBag;
    }

    public PokemonRepository healPokemon(PokemonRepository pokemon, double health){

        pokemon.changeHealth(health);

        return pokemon;
    }
}
