package com.axweb.pokemon.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(val results: ArrayList<Tipo>) : Parcelable {

    @Parcelize
    data class Tipo(
        val thumbnailImage: String = "",
        val name: String = "",
    ) : Parcelable
}
