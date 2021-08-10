package com.axweb.pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.axweb.pokemon.R
import com.axweb.pokemon.model.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_type.view.*

class PokemonAdapter(val pokemons : ArrayList<Pokemon>): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_list_type,parent,false)
        return PokemonViewHolder(itemView)
    }
    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.bind(pokemon)

    }
    class PokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(pokemon: Pokemon) {
            itemView.tv_tipo.text = pokemon.name
            Picasso.get().load(pokemon.thumbnailImage).into(itemView.iv_pokemon);
        }

    }

}

