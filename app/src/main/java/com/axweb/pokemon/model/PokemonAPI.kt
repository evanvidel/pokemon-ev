package com.axweb.pokemon.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokemonAPI {

   @GET("files/pokemon/data/types.json")
    fun listTypes(): Call<Result>

    @GET("files/pokemon/data/pokemons.json")
    fun listPokemons(): Call<ArrayList<Pokemon>>
}
fun retrofit(): Retrofit = Retrofit.Builder()
    .baseUrl("https://vortigo.blob.core.windows.net/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()






