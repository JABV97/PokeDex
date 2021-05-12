package com.example.pokedexjorge.service

import com.example.pokedexjorge.retrofit.PokeApiResponse
import com.example.pokedexjorge.retrofit.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {
    // INFORMACION DEL POKEMON
    @GET("pokemon/{id}")
    fun getPokemonInfo(@Path("id") id: Int): Call<Pokemon>

    //INFORMACION DE LA LISTA DE LA POKEDEX
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<PokeApiResponse>
}