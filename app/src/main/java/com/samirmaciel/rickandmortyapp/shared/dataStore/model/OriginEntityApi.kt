package com.samirmaciel.rickandmortyapp.shared.dataStore.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OriginEntityApi(

    @SerializedName("name")
    val name : String?,

    @SerializedName("url")
    val url : String?
): Parcelable{
    constructor() : this("", "")
}
