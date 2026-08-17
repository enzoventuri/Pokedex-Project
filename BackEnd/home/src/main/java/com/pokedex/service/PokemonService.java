package com.pokedex.service;
import com.pokedex.data.DataBase;
import com.pokedex.enums.Type;
import com.pokedex.exceptions.PokemonNotExist;
import com.pokedex.model.Pokemon;
import org.springframework.stereotype.Service;

import java.security.cert.PolicyNode;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PokemonService {

    public PokemonService() {

       Pokemon pokemon = new Pokemon("Pikachu", 1, "Pika", Type.ELECTRICITY, null,100, 20, 5, 70, "Pikachu - Eletric Mouse");
       Pokemon pokemon2 = new Pokemon("Pikach", 2, "Pika", Type.DRAGON, null,60, 202, 57, 170, "Pikach - Eletri Mouse");
       Pokemon pokemon3 = new Pokemon("Pikac", 3, "Pika", Type.FAIRY, null,50, 201, 51, 720, "Pikac - Eletr Mouse");
       Pokemon pokemon4 = new Pokemon("Pika", 4, "Pika", Type.FIRE, null,80, 420, 53, 7110, "Pika - Elet Mouse");
       Pokemon pokemon5 = new Pokemon("Pik", 5, "Pika", Type.GRASS, null,700, 120, 55, 720, "Pik - Ele Mouse");


       DataBase.pokemonInBag.add(pokemon);
       DataBase.pokemonInBag.add(pokemon2);
       DataBase.pokemonInBag.add(pokemon3);
       DataBase.pokemonInBag.add(pokemon4);
       DataBase.pokemonInBag.add(pokemon5);
       DataBase.activePokemon = pokemon4;
    }

    public Pokemon getActivePokemon(int id){

        if(DataBase.activePokemon.getId() != id){

            throw new PokemonNotExist("Pokemon not exist or not active");

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

    public List<Pokemon> getPokemons() {
        return DataBase.pokemonInBag;

    }

}
