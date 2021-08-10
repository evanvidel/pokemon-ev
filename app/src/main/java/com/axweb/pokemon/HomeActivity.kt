package com.axweb.pokemon

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.axweb.pokemon.adapter.PokemonAdapter
import com.axweb.pokemon.adapter.TypeAdapter
import com.axweb.pokemon.databinding.ActivityHomeBinding
import com.axweb.pokemon.model.*
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initTypes()
        initPokemons()
    }

    private fun initPokemons() {


        retrofit().create(PokemonAPI::class.java)
            .listPokemons()
            .enqueue(object : Callback<ArrayList<Pokemon>> {
                override fun onFailure(call: Call<ArrayList<Pokemon>>, t: Throwable) {
                    Toast.makeText(this@HomeActivity, "Erro no servidor!", Toast.LENGTH_SHORT)
                        .show()
                    t.printStackTrace()
                }

                override fun onResponse(call: Call<ArrayList<Pokemon>>, response: Response<ArrayList<Pokemon>>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                           val pokemonAdapter = PokemonAdapter(it)
                            binding.rvPokemon.layoutManager =LinearLayoutManager(this@HomeActivity)
                            binding.rvPokemon.adapter = pokemonAdapter
                        }
                    }
                }
            })
    }

    fun initTypes() {
        val tipos = arrayListOf<Result.Tipo>()

        val typeAdapter = TypeAdapter(tipos)
        rv_types.adapter = typeAdapter
        rv_types.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        retrofit().create(PokemonAPI::class.java)
            .listTypes()
            .enqueue(object : Callback<Result> {
                override fun onFailure(call: Call<Result>, t: Throwable) {
                    Toast.makeText(this@HomeActivity, "Erro no servidor!", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onResponse(call: Call<Result>, response: Response<Result>) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            typeAdapter.tipos.clear()
                            typeAdapter.tipos.addAll(it.results)
                            typeAdapter.notifyDataSetChanged()
                        }
                    }
                }
            })
    }

}