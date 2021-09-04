package com.pokedex.data;

import com.pokedex.models.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
    long count();
    Page<Pokemon> findAll(Pageable pageable);
}
