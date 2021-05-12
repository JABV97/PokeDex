package com.example.pokedexjorge.room.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexjorge.R
import com.example.pokedexjorge.model.Pokemon
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlinx.android.synthetic.main.pokemonsearch.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var pokemonList = emptyList<Pokemon>()
    class MyViewHolder(itemView: View):  RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = pokemonList[position]
        holder.itemView.id_text.text = currentItem.id.toString()
        holder.itemView.nombre_text.text = currentItem.name

        holder.itemView.rowLayout.setOnClickListener{
            val action = listFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)

        }
    }

    fun setData(pokemon: List<Pokemon>){
        this.pokemonList = pokemon
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return pokemonList.size

    }


}