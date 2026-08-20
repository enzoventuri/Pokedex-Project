package com.pokedex.service;
import com.pokedex.enums.Leader;
import com.pokedex.enums.Trainer;
import com.pokedex.enums.Type;
import com.pokedex.exceptions.AlreadyInBattle;
import com.pokedex.exceptions.ArenaNotFound;
import com.pokedex.model.Arena;
import com.pokedex.model.Pokemon;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class BattleService {



    public Arena startBattle(){

        if(DataBase.arena != null){
            if (DataBase.arena.getChampion() != null) {
                DataBase.arena = null;
            } else {
                throw new AlreadyInBattle("You are already in a battle!");
            }
        }

        Arena arena = new Arena("Lumiose Conference Stadium",
                DataBase.trainer, Type.NORMAL, Leader.BROCK,
                DataBase.listOfWildPokemons.get(new Random().nextInt(DataBase.listOfWildPokemons.size())));

        DataBase.arena = arena;

        return arena;
    }

    public String attackOpponent(){

        Arena arena = DataBase.arena;
        Pokemon enemyPokemon = arena.getPokemons();
        Pokemon pokemon = DataBase.activePokemon;


        if(arena == null){
            throw new ArenaNotFound("Arena is not started!");
        }

        int teamDodgeChance = new Random().nextInt(100);
        int enemyDodgeChance = new Random().nextInt(100);
        if(enemyDodgeChance < 5){
            arena.setSomeoneDodge(arena.getPokemons());
        } else if (teamDodgeChance < 5) {
            arena.setSomeoneDodge(pokemon);
        }

        Pokemon pokemonDodge = arena.getSomeoneDodge();
        arena.setSomeoneDodge(null);

        if(pokemonDodge != enemyPokemon){

            double attackDamage = pokemon.attack();
            boolean isEnemyAlive = enemyPokemon.changeHealth(-attackDamage);
            if(!isEnemyAlive){
                arena.setChampion(arena.getTrainer());
            }

        }
        if (pokemonDodge != pokemon) {

            double enemyAttackDamage = enemyPokemon.attack();
            boolean isAlive = pokemon.changeHealth(-enemyAttackDamage);
            if(!isAlive){
                arena.setChampion(arena.getLeader());
            }
        }

        Object ended = arena.getChampion();

        if(!ended.equals("In battle")){
            if (ended.getClass().equals(Trainer.class)) {
                return arena.getPokemons().faintPokemon()
                        + "\nThe game is over! \nChampion: " + arena.getChampion();

            }

            return pokemon.faintPokemon()
                    + "\nThe game is over! \nChampion: " + arena.getChampion();

        }

        if(pokemonDodge != null){
            return "Round Statistics \n\nYour pokemon:\n" +
                    "\nName: " + pokemon.getName()
                    + "\nHealth: " + pokemon.getHealth()
                    + "\nAttack: " + pokemon.attack()
                    + "\n\nOponent Pokemon: "
                    + "\nName: " + arena.getPokemons().getName()
                    + "\nHealth: " + arena.getPokemons().getHealth()
                    + "\nAttack: " + arena.getPokemons().getAttack()
                    + "\n\nThe " + pokemonDodge.dodgePokemon();
        }else {
            return "Round Statistics \n\nYour pokemon:\n" +
                    "\nName: " + pokemon.getName()
                    + "\nHealth: " + pokemon.getHealth()
                    + "\nAttack: " + pokemon.attack()
                    + "\n\nOponent Pokemon: "
                    + "\nName: " + arena.getPokemons().getName()
                    + "\nHealth: " + arena.getPokemons().getHealth()
                    + "\nAttack: " + arena.getPokemons().getAttack();
        }

    }

    public String fleeBattle(){

        Arena arena = DataBase.arena;
        Pokemon pokemon = DataBase.activePokemon;

        if(arena == null){
            throw new ArenaNotFound("Arena not found");
        }

        String message =  "Battle Statistics \n\nYour pokemon:\n" +
                "\nName: " +  pokemon.getName()
                + "\nHealth: " + pokemon.getHealth()
                + "\nAttack: " + pokemon.attack()
                + "\n\nOponent Pokemon: "
                + "\nName: " + arena.getPokemons().getName()
                + "\nHealth: " + arena.getPokemons().getHealth()
                + "\nAttack: " + arena.getPokemons().getAttack()
                + "\n" + pokemon.flee()
                + "\n\nGame Over "
                + arena.getLeader().name() + " Win the battle";

        DataBase.arena = null;

        return message;
    }
}
