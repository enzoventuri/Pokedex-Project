package com.pokedex.repository;
import com.pokedex.model.Game;
import com.pokedex.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Integer> {
    Game findFirstByIsFinishedFalse();
}
