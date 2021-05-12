package com.example.pokedexjorge.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokeApiResponse (
    @SerializedName("count")
    @Expose
    val count: Int,

    @SerializedName("next")
    @Expose
    val next: String,

    @SerializedName("previous")
    @Expose
    val previous: String,

    @SerializedName("results")
    @Expose
    val results: List<PokeResult>
)

data class PokeResult (
    @SerializedName("name")
    @Expose
    val name: String,

    @SerializedName("url")
    @Expose
    val url: String
)