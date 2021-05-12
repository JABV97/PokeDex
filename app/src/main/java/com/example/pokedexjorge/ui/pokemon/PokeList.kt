package com.example.pokedexjorge.ui.pokemon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedexjorge.R
import kotlinx.android.synthetic.main.pokelist.*

class PokeList : AppCompatActivity() {
    private lateinit var viewModel: PokeListVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokelist)

        viewModel = ViewModelProvider(this).get(PokeListVM::class.java)

        initUI()
    }

    private fun initUI(){
        pokelistRecyclerView.layoutManager = GridLayoutManager(this, 2)
        pokelistRecyclerView.adapter = PokeListAdapter{
            val intent = Intent(this, PokeInfo::class.java)
            intent.putExtra("id", it)
            startActivity(intent)

        }

        viewModel.getPokemonList()

        viewModel.pokemonList.observe(this, Observer { list ->
            (pokelistRecyclerView.adapter as PokeListAdapter).setData(list)
        })
    }
}