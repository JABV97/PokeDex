package com.example.pokedexjorge.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pokedexjorge.model.Pokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface pokemonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPokemon(pokemon: Pokemon)

    @Update
    suspend fun updatePokemon(pokemon: Pokemon)

    @Delete
    suspend fun deletePokemon(pokemon: Pokemon)

    @Query("DELETE FROM pokemon_table")
    suspend fun deleteAllPokemons()

    @Query("SELECT * FROM pokemon_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Pokemon>>
}