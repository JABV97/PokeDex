package com.example.pokedexjorge.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Pokemon(
        @SerializedName("id")
   @Expose
   val id: Int,

        @SerializedName("name")
   @Expose
   val name: String,

        @SerializedName("weight")
   @Expose
   val weight: Int,

        @SerializedName("height")
   @Expose
   val height: Int,


        @SerializedName("base_experience")
   @Expose
   val base_experience: Int,


        @SerializedName("sprites")
   @Expose
   val spritesEntity: SpritesEntity,

        )

data class SpritesEntity (
   @SerializedName("front_default")
   @Expose
   val frontDefault: String?,

   @SerializedName("front_shiny")
   @Expose
   val frontShiny: String?
)