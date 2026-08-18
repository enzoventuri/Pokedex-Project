package com.pokedex.controller;

import com.pokedex.enums.Items;
import com.pokedex.model.Pokemon;
import com.pokedex.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/pokedex/game")
public class GameController {

    private GameService service;

    @Autowired
    public GameController(GameService gameService){this.service = gameService;}

    @GetMapping("/team")
    public ResponseEntity<List<Pokemon>> getTeam(){
        try {

            List<Pokemon> list = service.getTeam();

            return ResponseEntity.ok(list);

        }catch(RuntimeException e){

            return ResponseEntity.notFound().build();

        }
    }

    @PatchMapping("/heal/{id}")
    public ResponseEntity<Pokemon> healPokemon(@PathVariable int id, @RequestParam double health){
        try {

            Pokemon pokemon = service.healPokemon(id, health);

            return ResponseEntity.ok(pokemon);

        }catch (RuntimeException e){

            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping("/move")
    public ResponseEntity<String> moveTrainer(){

        try {

            return ResponseEntity.ok(service.moveTrainer() + " has moved!");

        }catch (RuntimeException e){

            return ResponseEntity.notFound().build();

        }
    }

    @PostMapping("/item")
    public ResponseEntity<Items> buyItem(@RequestParam Items item) {
        try {
            return ResponseEntity.ok(service.buyItem(item));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/use-item")
    public ResponseEntity<Items> useItem(@RequestParam Items item) {
        try {
            return ResponseEntity.ok(service.useItem(item));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/capture")
    public ResponseEntity<Pokemon> capturePokemon() {
        try {
            return ResponseEntity.ok(service.capturePokemon());
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
