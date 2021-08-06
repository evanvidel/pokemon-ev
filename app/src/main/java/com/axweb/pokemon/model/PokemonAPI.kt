package com.axweb.pokemon.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.sql.Types

interface PokemonAPI {

    @GET("files/pokemon/data/types.json")
    fun listTypes(): Call<Result>
}

fun retrofit(): Retrofit = Retrofit.Builder()
    .baseUrl("https://vortigo.blob.core.windows.net/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()