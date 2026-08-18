package com.pokedex.controller;

import com.pokedex.enums.Evolutions;
import com.pokedex.model.Pokemon;
import com.pokedex.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/faint/{id}")
    public ResponseEntity<String> faintPokemon(@PathVariable int id){
        try {
            Pokemon pokemon = service.checkIfPokemonExists(id);
            return ResponseEntity.ok(pokemon.getName() + " has fainted!");

        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dodge/{id}")
    public ResponseEntity<String> dodgePokemon(@PathVariable int id) {
        try {
            Pokemon pokemon = service.getActivePokemon(id);

            return ResponseEntity.ok(pokemon.getName() + " has dodged the attack!");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/level-up/{id}")
    public ResponseEntity<String> levelUpPokemon(@PathVariable int id, @RequestParam int levels) {
        try {
            Pokemon pokemon = service.checkIfPokemonExists(id);
            int amountLeveled = service.levelUp(pokemon, levels);

            return ResponseEntity.ok(pokemon.getName() + " has leveled up " + amountLeveled + " levels!");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/evolve/{id}")
    public ResponseEntity<String> evolvePokemon(@PathVariable int id) {
        try {

            Pokemon pokemon = service.checkIfPokemonExists(id);

            Evolutions evolution = service.evolvePokemon(pokemon);

            return ResponseEntity.ok(pokemon.getName() + " has evolved to " + evolution);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
