package com.example.pokedexjorge.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.pokedexjorge.model.Pokemon
import com.example.pokedexjorge.room.pokemonDao
import kotlinx.coroutines.flow.Flow

class pokemonRepository(private val pokemonDao: pokemonDao) {

    val readAllData: LiveData<List<Pokemon>> = pokemonDao.readAllData()

    suspend fun addPokemon(pokemon: Pokemon){
        pokemonDao.addPokemon(pokemon)
    }

    suspend fun updatePokemon(pokemon: Pokemon){
        pokemonDao.updatePokemon(pokemon)
    }

    suspend fun deletePokemon(pokemon: Pokemon){
        pokemonDao.deletePokemon(pokemon)
    }

    suspend fun deleteAllPokemons(){
        pokemonDao.deleteAllPokemons()
    }
}