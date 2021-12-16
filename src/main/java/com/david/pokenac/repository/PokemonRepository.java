package com.david.pokenac.repository;

import com.david.pokenac.model.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository
        extends JpaRepository<Pokemon, Long> {
    @Query("SELECT p FROM Pokemon p ORDER BY p.id")
    List<Pokemon> findAll();

    @Query("SELECT p FROM Pokemon p ORDER BY p.id")
    Page<Pokemon> findAll(Pageable page);

    List<Pokemon> findPokemonsByNameContaining(String name);
}
