package com.example.pokedexjorge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.pokedexjorge.room.fragments.MainNavigation
import com.example.pokedexjorge.room.fragments.listFragment
import com.example.pokedexjorge.ui.pokemon.PokeInfo
import com.example.pokedexjorge.ui.pokemon.PokeList
import com.example.pokedexjorge.ui.pokemon.PokeListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.pokedexbtn)
        button.setOnClickListener {
            val intent = Intent(this, PokeList::class.java)
            startActivity(intent)
        }

        val button2: Button = findViewById(R.id.roomBTN)
        button2.setOnClickListener{
            val intent = Intent(this, MainNavigation::class.java)
            startActivity(intent)
        }
    }
}