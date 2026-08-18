package com.pokedex.controller;

import com.pokedex.data.DataBase;
import com.pokedex.enums.Trainer;
import com.pokedex.model.Arena;
import com.pokedex.model.Pokemon;
import com.pokedex.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("v1/pokedex/game/battle")
public class BattleController {

    private BattleService service;

    @Autowired
    void BattleController(BattleService service){
        new DataBase();

        this.service = service;
        Pokemon pokemon4 = DataBase.listOfWildPokemons.get(new Random().nextInt(DataBase.listOfWildPokemons.size()));
        DataBase.activePokemon = pokemon4;

    }

    @PostMapping("/start")
    public ResponseEntity<String> startBattle(){

        try {

            Arena arena = service.startBattle();

            return ResponseEntity.ok("Battle Started in Arena: " + arena.getName()
                            + " \n" + arena.getTrainer().name() + " vs " + arena.getLeader().name());

        }catch (RuntimeException e){

            return ResponseEntity.notFound().build();

        }
    }

    @PatchMapping("/attack")
    public ResponseEntity<String> attackEnemy(){

        try {

            Arena arena = service.attackOpponent();
            Object ended = arena.getChampion();

            if(!ended.equals("In battle")){
                if (ended.getClass().equals(Trainer.class)) {
                    return ResponseEntity.ok(arena.getPokemons().faintPokemon()
                            + "\nThe game is over! \nChampion: " + arena.getChampion());

                }

                return ResponseEntity.ok( DataBase.activePokemon.faintPokemon()
                        + "\nThe game is over! \nChampion: " + arena.getChampion());

            }

            return ResponseEntity.ok(" Round Statistics \n\n Your pokemon:\n" +
                    "\nName: " +  DataBase.activePokemon.getName()
                    + "\nHealth: " + DataBase.activePokemon.getHealth()
                    + "\nAttack: " + DataBase.activePokemon.attack()
                    + "\n\nOponent Pokemon: "
                    + "\nName: " + arena.getPokemons().getName()
                    + "\nHealth: " + arena.getPokemons().getHealth()
                    + "\nAttack: " + arena.getPokemons().getAttack()
                    );

        }catch (RuntimeException e){

            return ResponseEntity.notFound().build();

        }
    }

}
