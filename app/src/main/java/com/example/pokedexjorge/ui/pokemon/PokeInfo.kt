package com.example.pokedexjorge.ui.pokemon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.pokedexjorge.R
import kotlinx.android.synthetic.main.pokeinfo.*

class PokeInfo : AppCompatActivity() {
    lateinit var viewModel: PokeInfoVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokeinfo)

        viewModel = ViewModelProvider(this).get(PokeInfoVM::class.java)

        initUI()

    }

    private fun initUI(){
        val id = intent.extras?.get("id") as Int

        viewModel.getPokemonInfo(id)

        viewModel.pokemonInfo.observe(this, Observer { pokemon ->
            nombreTextView.text = pokemon.name
            alturaTextView.text = "Altura: ${pokemon.height/10.0}m"
            pesoTextView.text = "Peso: ${pokemon.weight/10.0} kg"
            experienceTextView.text = "Experiencia: ${pokemon.base_experience/10.0} exp"

            Glide.with(this).load(pokemon.spritesEntity.frontDefault).into(imageView)
        })
    }



}