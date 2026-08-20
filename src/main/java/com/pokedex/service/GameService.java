package com.pokedex.service;

import com.pokedex.enums.Items;
import com.pokedex.enums.Leader;
import com.pokedex.enums.Trainer;
import com.pokedex.enums.Type;
import com.pokedex.exceptions.*;
import com.pokedex.model.Arena;
import com.pokedex.model.Game;
import com.pokedex.model.Pokemon;
import com.pokedex.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class GameService {

    private PokemonService pokemonService;
    private GameRepository repository;

    @Autowired
    GameService(PokemonService pokemonService, GameRepository repository){
        this.pokemonService = pokemonService;
        this.repository = repository;
    }

    public Game startGame() {
        Game game = repository.findFirstByIsFinishedFalse();

        ArrayList<Pokemon> pokemons = pokemonService.getWildPokemons();
        ArrayList<Pokemon> pokemonsInBag = new ArrayList<>();
        Pokemon pokemon = pokemons.get(new Random().nextInt(pokemons.size()));
        Pokemon leaderPokemon = pokemons.get(new Random().nextInt(pokemons.size()));

        for (int i = 0; i < 5; i++) {

            boolean isDuplicated = false;
            int randomPokemon = new Random().nextInt(pokemons.size());

            for (int j = 0; j < pokemonsInBag.size(); j++) {
                if (pokemonsInBag.get(j).getId() == randomPokemon) {

                    isDuplicated = true;

                }else{
                    j ++;
                }
            }

            if(isDuplicated){

                i--;

            }else{

                pokemonsInBag.add(pokemons.get(i));

                i++;

            }
        }

        Trainer trainer = Trainer.getTrainerFromNumber(new Random().nextInt(2));
        Leader leader = Leader.getLeaderFromNumber(new Random().nextInt(5));

        Arena arena = new Arena("Arena Maximuns",trainer, Type.getTypeFromNumber(new Random().nextInt(2)),leader, leaderPokemon);

        if (game == null) {
            game = new Game(pokemonsInBag,Items.getAll(),pokemon,trainer,arena,false);
            return repository.save(game);
        }

        game.setFinished(true);

        repository.save(game);

        Game newGame = new Game(pokemonsInBag,Items.getAll(),pokemon,trainer,arena,false);

        repository.save(newGame);

        return newGame;
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
            throw new ItemNotFound("No Item Found!");
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
