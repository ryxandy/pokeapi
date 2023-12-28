package com.pokedex.pokeapi.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pokedex.pokeapi.entity.Pokemon;
import com.pokedex.pokeapi.repository.PokemonRepository;

@RestController
public class PokemonResource {

	@Autowired
	private PokemonRepository repository;


	@GetMapping(path = "/pokemons")
	public List<Pokemon> getAll(){
		return repository.findAll();
	}

	@PostMapping(value = "/pokemons")
	public ResponseEntity<Pokemon> addPokemon(@Valid @RequestBody Pokemon pokemon) {
		repository.save(pokemon);
		System.out.println("A new Pokemon was created");
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(path = "/pokemon/{id}")
	public Optional<Pokemon> getOneByID (@PathVariable int id) {
		System.out.println("Found a pokemon! ");
		return repository.findById(id);
	}


	@GetMapping(value = "/pokemon/fraqueza/{fraqueza}")
	public Pokemon findByFraqueza (@PathVariable String fraqueza) {
		System.out.println("Found a pokemon! ");
		return repository.findByFraqueza(fraqueza);
	}

	@GetMapping(value = "/pokemon/nome/{nome}")
	public Pokemon findByNome (@PathVariable String nome) {
		return repository.findByNome(nome);
	}

	@DeleteMapping(path = "/pokemon/{id}")
	public void DeletePokemon(@PathVariable int id) {
		System.out.println("Deleted a pokemon :( ");
		repository.deleteById(id);
	}
}
