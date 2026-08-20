package com.pokedex.repository;
import com.pokedex.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
