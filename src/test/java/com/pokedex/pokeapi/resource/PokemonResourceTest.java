package com.pokedex.pokeapi.resource;

import com.pokedex.pokeapi.entity.Pokemon;
import com.pokedex.pokeapi.repository.PokemonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;


class PokemonResourceTest {

    @Mock
    private PokemonRepository repository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("Should add a Pokemon")
    void addPokemon() {
        Pokemon pokemon = new Pokemon(1,"Dragonite", "Dragão", "", true);
        repository.save(pokemon);
        when(repository.save(pokemon)).thenReturn(pokemon);
        verify(repository,times(1)).save(pokemon);
    }

    @Test
    @DisplayName("Should get one pokemon using his id")
    void getOneByID() {
        Pokemon pokemon = new Pokemon(1,"Dragonite", "Dragão", "", true);
        repository.getOne(pokemon.getId());
        when(repository.getOne(pokemon.getId())).thenReturn(pokemon);
        verify(repository,times(1)).getOne(pokemon.getId());
    }

    @Test
    void findByFraqueza() {
        Pokemon pokemon = new Pokemon(1,"Dragonite", "Dragão", "", true);
        repository.findByFraqueza(pokemon.getFraqueza());
        when(repository.findByFraqueza(pokemon.getFraqueza())).thenReturn(pokemon);
        verify(repository,times(1)).findByFraqueza(pokemon.getFraqueza());
    }

    @Test
    void findByNome() {
        Pokemon pokemon = new Pokemon(1,"Dragonite", "Dragão", "", true);
        repository.findByNome(pokemon.getNome());
        when(repository.findByNome(pokemon.getNome())).thenReturn(pokemon);
        verify(repository,times(1)).findByNome(pokemon.getNome());
    }

    @Test
    void deletePokemon() {
        Pokemon pokemon = new Pokemon(1,"Dragonite", "Dragão", "", true);
        repository.deleteById(pokemon.getId());
        verify(repository,times(1)).deleteById(pokemon.getId());
    }
}
