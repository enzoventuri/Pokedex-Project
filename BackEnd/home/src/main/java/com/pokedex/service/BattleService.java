package com.pokedex.service;

import com.pokedex.data.DataBase;
import com.pokedex.enums.Leader;
import com.pokedex.enums.Type;
import com.pokedex.exceptions.AlreadyInBattle;
import com.pokedex.exceptions.ArenaNotFound;
import com.pokedex.model.Arena;
import com.pokedex.model.Pokemon;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Random;

@Service
public class BattleService {

    public Arena startBattle(){

        if(DataBase.arena != null){
            if (!DataBase.arena.getChampion().equals("In battle")) {
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

    public Arena attackOpponent(){

        Arena arena = DataBase.arena;

        if(arena == null){
            throw new ArenaNotFound("Arena is not started!");
        }

        Pokemon enemyPokemon = arena.getPokemons();
        Pokemon pokemon = DataBase.activePokemon;
        double attackDamage = pokemon.attack();

        boolean isEnemyAlive = enemyPokemon.changeHealth(-attackDamage);

        if(isEnemyAlive == false){
            arena.setChampion(arena.getTrainer());
        }

        double enemyAttackDamage = enemyPokemon.attack();
        boolean isAlive = pokemon.changeHealth(-enemyAttackDamage);

        if(isAlive == false){
            arena.setChampion(arena.getLeader());
        }

        return arena;

    }
}
