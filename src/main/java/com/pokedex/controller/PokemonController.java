package com.pokedex.controller;
import com.pokedex.model.Pokemon;
import com.pokedex.service.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controller responsible for Pokemon interaction/status
 *
 * @author Eduardo Geffert da Silva and Enzo Venturi
 * @since v0.1
 */
@Tag(
    name = "Pokemon Controller",
    description = "Controller responsible for HTTP Pokemons interactions"
)
@RestController
@RequestMapping("/v1/pokedex")
public class PokemonController {

    private PokemonService service;


    @Autowired
    public PokemonController(PokemonService service) {
        this.service = service;
    }

    /**
     * List of all Pokemons in bag
     *
     * <p>Includes active Pokemon</p>
     *
     * @return Pokemon List
     */
    @Operation(
        summary = "All Pokemons in inventory",
        description = "Lists every Pokemon in bag"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "List of Pokemons"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Server side error"
            )
    })
    @GetMapping("/pokemons")
    public ResponseEntity<List<Pokemon>> allPokemons(){

        try {

            List<Pokemon> pokemons = service.getPokemons();

            return ResponseEntity.ok(pokemons);

        }catch (RuntimeException e) {

            return ResponseEntity.notFound().build();

        }
    }

    /**
     * Moves the active Pokemon
     *
     * @return String
     */
    @Operation(
            summary = "Moves Pokemon",
            description = "Moves only the active Pokemon based on the ID given"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "[Pokemon] has Moved!"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pokemon Not Found"
            )
    })
    @GetMapping("/move/{id}")
    public ResponseEntity<String> movePokemon(@PathVariable int id){
        try {
            Pokemon pokemon = service.getActivePokemon(id);

            return ResponseEntity.ok(pokemon.movePokemon());

        }catch (RuntimeException e) {

            return ResponseEntity.notFound().build();

        }
    }

    /**
     * Faints the Pokemon
     *
     * @return String
     */
    @Operation(
            summary = "Faints Pokemon",
            description = "Faints a Pokemon based on the ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "[Pokemon] has Fainted!"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pokemon Not Found"
            )
    })
    @PatchMapping("/faint/{id}")
    public ResponseEntity<String> faintPokemon(@PathVariable int id){
        try {
            Pokemon pokemon = service.checkIfPokemonExists(id);
            return ResponseEntity.ok(pokemon.faintPokemon());

        }catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Makes the Pokemon dodge
     *
     * @return String
     */
    @Operation(
            summary = "Pokemon Dodge",
            description = "Makes a Pokemon dodge based on its ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "[Pokemon] has Dodged!"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pokemon Not Found"
            )
    })
    @GetMapping("/dodge/{id}")
    public ResponseEntity<String> dodgePokemon(@PathVariable int id) {
        try {
            Pokemon pokemon = service.getActivePokemon(id);
            return ResponseEntity.ok(pokemon.dodgePokemon());
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Levels Up the Pokemon
     *
     * @return String
     */
    @Operation(
            summary = "Levels up a Pokemon",
            description = "Levels up a Pokemon based on the ID and the quantity of levels given"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "[Pokemon] has leveled up [quantity of levels] levels!"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pokemon Not Found"
            )
    })
    @PatchMapping("/level-up/{id}")
    public ResponseEntity<String> levelUpPokemon(@PathVariable int id, @RequestParam int levels) {
        try {
            Pokemon pokemon = service.checkIfPokemonExists(id);
            String levelup = service.levelUp(pokemon, levels);
            return ResponseEntity.ok(levelup);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Evolves the Pokemon
     *
     * @return String
     */
    @Operation(
            summary = "Evolves a Pokemon",
            description = "Evolves a Pokemon based on the ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "[Pokemon] has evolved to [Evolution]!"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Pokemon Not Found"
            )
    })
    @PatchMapping("/evolve/{id}")
    public ResponseEntity<String> evolvePokemon(@PathVariable int id) {
        try {

            Pokemon pokemon = service.checkIfPokemonExists(id);
            String messageEvolution = service.evolvePokemon(pokemon);
            return ResponseEntity.ok(messageEvolution);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
