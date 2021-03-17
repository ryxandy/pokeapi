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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pokedex.pokeapi.entity.Pokemon;
import com.pokedex.pokeapi.repository.PokemonRepository;

@RestController
public class PokemonResource {

	@Autowired
	private PokemonRepository repository;
	
	@SuppressWarnings("unused")
	private Pokemon savePokemon;
	
	
	//Get All Pokemons
	@GetMapping(path = "/pokemons")
	public List<Pokemon> getAll(){
		return repository.findAll();
	}
	
	@RequestMapping(value = "/pokemons", method = RequestMethod.POST)
	public ResponseEntity<Pokemon> addPokemon(@Valid @RequestBody Pokemon pokemon) {
		savePokemon = repository.save(pokemon);
		System.out.println("A new Pokemon was created");
		return new ResponseEntity<Pokemon>(HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/pokemon/{id}")
	public Optional<Pokemon> getOneByID (@PathVariable int id) {
		System.out.println("Found a pokemon! ");
		return repository.findById(id);
	}
	
	
	@RequestMapping(value = "/pokemon/fraqueza/{fraqueza}", method = RequestMethod.GET)
	public Pokemon findByFraqueza (@PathVariable String fraqueza) {
		System.out.println("Found a pokemon! ");
		return repository.findByFraqueza(fraqueza);
	}
	
	@RequestMapping(value = "/pokemon/nome/{nome}", method = RequestMethod.GET)
	public Pokemon findByNome (@PathVariable String nome) {
		return repository.findByNome(nome);
	}
	
	@DeleteMapping(path = "/pokemon/{id}")
	public void DeletePokemon(@PathVariable int id) {
		System.out.println("Deleted a pokemon :( ");
		repository.deleteById(id);
	}
}
