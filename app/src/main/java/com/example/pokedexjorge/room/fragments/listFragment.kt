package com.example.pokedexjorge.room.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexjorge.R
import com.example.pokedexjorge.room.PokemonViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class listFragment : Fragment() {

    private lateinit var mPokemonViewModel: PokemonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val adapter = ListAdapter()
        val recyclerView = view.pokemonRoomRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mPokemonViewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)
        mPokemonViewModel.readAllData.observe(viewLifecycleOwner, Observer { pokemon ->
            adapter.setData(pokemon)
        })

        view.floatingActionButton2.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view
    }

}