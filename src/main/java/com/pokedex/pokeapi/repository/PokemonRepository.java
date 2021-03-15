package com.pokedex.pokeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pokedex.pokeapi.entity.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon,Integer> {

	public Pokemon findByFraqueza(String fraqueza);
	public Pokemon findByNome(String nome);
}
