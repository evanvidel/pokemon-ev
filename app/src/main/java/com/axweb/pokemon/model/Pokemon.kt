package com.axweb.pokemon.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Pokemon(
    val abilities: List<String>,
    val collectibles_slug: String,
    val detailPageURL: String,
    val featured: String,
    val height: Int,
    val id: Int,
    val name: String = "",
    val number: String,
    val slug: String,
    val thumbnailAltText: String,
    val thumbnailImage: String = "",
    val type: List<String>,
    val weakness: List<String>,
    val weight: Double
):Parcelable