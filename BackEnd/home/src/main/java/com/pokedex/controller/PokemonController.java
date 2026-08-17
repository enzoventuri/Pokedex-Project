package com.pokedex.controller;

import com.pokedex.model.Pokemon;
import com.pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/pokedex")
public class PokemonController {

    private PokemonService service;


    @Autowired
    public PokemonController(PokemonService service) {
        this.service = service;
    }


    @GetMapping("/pokemons")
    public ResponseEntity<List<Pokemon>> allPokemons(){

        try {

            List<Pokemon> pokemons = service.getPokemons();

            return ResponseEntity.ok(pokemons);

        }catch (RuntimeException e) {

            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping("/move/{id}")
    public ResponseEntity<String> movePokemon(@PathVariable int id){
        try {
            Pokemon pokemon = service.getActivePokemon(id);

            return ResponseEntity.ok(pokemon.getName() + " has moved!");

        }catch (RuntimeException e) {

            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping("/faint/{id}")
    public ResponseEntity<String> faintPokemon(@PathVariable int id){
        try {
            Pokemon pokemon = service.checkIfPokemonExists(id);
            return ResponseEntity.ok(pokemon.getName() + " has fainted!");

        }catch (RuntimeException e) {

            return ResponseEntity.notFound().build();

        }
    }



}
