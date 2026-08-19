package com.pokedex.controller;
import com.pokedex.data.DataBase;
import com.pokedex.model.Arena;
import com.pokedex.model.Pokemon;
import com.pokedex.service.BattleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

/**
 * Controller responsible for Battle interaction/status
 *
 * @author Eduardo Geffert da Silva and Enzo Venturi
 * @since v0.1
 */
@Tag(
        name = "Battle Controller",
        description = "Controller responsible for HTTP Battles interactions"
)
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

    /**
     * Start a Single Battle
     *
     * <p>Start only a battle per time</p>
     *
     * @return String showing the Trainer, Leadaer and Arena
     */
    @Operation(
            summary = "Start a battle",
            description = "Start a single battle per time"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Battle started"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Server side error"
            )
    })
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

    /**
     * Make an attack in the battle
     *
     * <p>Attack the opponent's Pokemon and receive some attack</p>
     *
     * @return A String that resumes the battle statistics
     */
    @Operation(
            summary = "All Pokemons in inventory",
            description = "Lists every Pokemon in bag"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Attack concluded"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Battle not found"
            )
    })
    @PatchMapping("/attack")
    public ResponseEntity<String> attackEnemy(){

        try {

            String message = service.attackOpponent();

            return ResponseEntity.ok(message);

        }catch (RuntimeException e){

            return ResponseEntity.notFound().build();

        }
    }

    /**
     * To flee the battle
     *
     * <p>The pokemon fled the battle</p>
     *
     * @return String describes the end of the battle
     */
    @Operation(
            summary = "Flee in the middle of the battle",
            description = "Before battles continues the Pokemon fled"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful flee attempt"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Battle not found"
            )
    })
    @PatchMapping("/flee")
    public ResponseEntity<String> fleeBattle(){
        try {

            return ResponseEntity.ok(service.fleeBattle());

        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

}
