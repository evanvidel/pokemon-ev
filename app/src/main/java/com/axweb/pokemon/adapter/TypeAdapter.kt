package com.axweb.pokemon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.axweb.pokemon.R
import com.axweb.pokemon.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_list_item.view.*


class TypeAdapter(val tipos: ArrayList<Result.Tipo>) : RecyclerView.Adapter<TypeAdapter.TypeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        val infrater = LayoutInflater.from(parent.context)
        val itemView = infrater.inflate(R.layout.pokemon_list_item, parent, false)
        return TypeViewHolder(itemView)
    }
    override fun getItemCount(): Int = tipos.size

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        val tipos = tipos[position]
        holder.bind(tipos)
    }

    class TypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tipos: Result.Tipo) {
            itemView.tv_name.text = tipos.name
            Picasso.get().load(tipos.thumbnailImage).into(itemView.iv_icon);
        }
    }
}

