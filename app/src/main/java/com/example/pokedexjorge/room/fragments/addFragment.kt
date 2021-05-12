@file:Suppress("DEPRECATION")

package com.example.pokedexjorge.room.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IntegerRes
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.pokedexjorge.R
import com.example.pokedexjorge.model.Pokemon
import com.example.pokedexjorge.room.PokemonViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class addFragment : Fragment() {

    private lateinit var mPokemonViewModel : PokemonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)


        mPokemonViewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)

        view.addBTN.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase(){
        val name = nombreEditText.text.toString()
        val weight = pesoEditText.text
        val height = alturaEditText.text
        val base_experience = expEditText.text

        if (inputCheck(name, weight, height, base_experience)){
            val pokemon = Pokemon(0 , name, Integer.parseInt(weight.toString()),Integer.parseInt(
                height.toString()
            ), Integer.parseInt(base_experience.toString()))
            mPokemonViewModel.addPokemon(pokemon)
            Toast.makeText(requireContext(), "Añadido Corretamente!", Toast.LENGTH_LONG ).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Porfavor revisar", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String, weight: Editable, height: Editable, base_experience: Editable ): Boolean{
        return !(TextUtils.isEmpty(name) && weight.isEmpty() && height.isEmpty() && base_experience.isEmpty())
    }

}