package com.example.pokedexjorge.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.pokedexjorge.model.Pokemon
import com.example.pokedexjorge.repository.pokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Pokemon>>
    private val repository: pokemonRepository

    init {
        val pokemonDao = PokemonDatabase.getDatabase(application).pokemonDao()
        repository = pokemonRepository(pokemonDao)
        readAllData = repository.readAllData
    }

    fun addPokemon(pokemon: Pokemon){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPokemon(pokemon)
        }
    }

    fun updatePokemon(pokemon: Pokemon){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePokemon(pokemon)
        }
    }

    fun deletePokemon(pokemon: Pokemon){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePokemon(pokemon)
        }
    }

    fun deleteAllPokemons(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllPokemons()
        }
    }
}