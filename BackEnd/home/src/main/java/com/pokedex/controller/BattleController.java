package com.pokedex.controller;

import com.pokedex.model.Battle;
import com.pokedex.model.Pokemon;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/battle")
public class BattleController {
    @PostMapping("/start")
    public Battle startBattle(Pokemon activePokemon, Pokemon adversaryPokemon) {
        return null;
    }
}
