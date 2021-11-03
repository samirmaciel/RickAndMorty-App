package com.samirmaciel.rickandmortyapp.shared.dataStore.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultsResponse(

    @SerializedName("results")
    val personsList : MutableList<PersonEntityApi>
) : Parcelable {
    constructor() : this(mutableListOf())
}

