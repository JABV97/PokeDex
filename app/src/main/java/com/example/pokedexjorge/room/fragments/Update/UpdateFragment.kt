package com.example.pokedexjorge.room.fragments.Update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.pokedexjorge.R
import com.example.pokedexjorge.model.Pokemon
import com.example.pokedexjorge.room.PokemonViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mPokemonViewModel : PokemonViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mPokemonViewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)

        view.UpdateNombreEditText.setText(args.currentPokemon.name)
        view.UpdatePesoEditText.setText(args.currentPokemon.weight.toString())
        view.UpdateAlturaEditText.setText(args.currentPokemon.height.toString())
        view.UpdateExpEditText.setText(args.currentPokemon.base_experience.toString())

        view.updateBTN.setOnClickListener {
            updateItem()
        }

        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem(){
        val name = UpdateNombreEditText.text.toString()
        val weight = Integer.parseInt(UpdatePesoEditText.text.toString())
        val height = Integer.parseInt(UpdateAlturaEditText.text.toString())
        val exp = Integer.parseInt(UpdateExpEditText.text.toString())

        if(inputCheck(name, UpdatePesoEditText.text, UpdateAlturaEditText.text, UpdateExpEditText.text)){
            val updatePokemon = Pokemon(args.currentPokemon.id, name, weight, height, exp)
            mPokemonViewModel.updatePokemon(updatePokemon)
            Toast.makeText(requireContext(), "Actualizado Exitosamente!", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Porfavor llena todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(name: String, weight: Editable, height: Editable, base_experience: Editable): Boolean{
        return !(TextUtils.isEmpty(name) && weight.isEmpty() && height.isEmpty() && base_experience.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deletePokemon()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deletePokemon() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Si"){ _, _ ->
            mPokemonViewModel.deletePokemon(args.currentPokemon)
            Toast.makeText(requireContext(), "Borrado Exitosamente: ${args.currentPokemon.name}",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No"){ _, _ ->}
        builder.setTitle("Borrar ${args.currentPokemon.name}?")
        builder.setMessage("Estas seguro que deseas borrar ${args.currentPokemon.name}?")
        builder.create().show()
    }


}