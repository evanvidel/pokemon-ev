package com.axweb.pokemon

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.axweb.pokemon.adapter.TypeAdapter
import com.axweb.pokemon.databinding.ActivityHomeBinding
import com.axweb.pokemon.model.PokemonAPI
import com.axweb.pokemon.model.Result
import com.axweb.pokemon.model.retrofit
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var typeAdapter: TypeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tipos = arrayListOf<Result.Tipo>()
        typeAdapter = TypeAdapter(tipos)
        rv_types.adapter = typeAdapter
        rv_types.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)



        retrofit().create(PokemonAPI::class.java)
            .listTypes()
            .enqueue(object : Callback<Result>{
                override fun onFailure(call: Call<Result>, t: Throwable) {
                    Toast.makeText(this@HomeActivity ,"Erro no servidor!", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Result>, response: Response<Result>) {
                    if (response.isSuccessful){
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