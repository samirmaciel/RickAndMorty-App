package com.samirmaciel.rickandmortyapp.shared.dataStore.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonEntityApi(

    @SerializedName("id")
    val id : Int?,

    @SerializedName("name")
    val name : String?,

    @SerializedName("status")
    val status : String?,

    @SerializedName("type")
    val type : String?,

    @SerializedName("gender")
    val gender : String?,

    @SerializedName("origin")
    val origin : OriginEntityApi,

    @SerializedName("location")
    val location : LocationEntityApi,

    @SerializedName("image")
    val image : String?,

    @SerializedName("episodes")
    val episodes : Array<String>,

    @SerializedName("url")
    val url : String?,

    @SerializedName("created")
    val created : String?

) : Parcelable {
    constructor() : this(0, "", "", "", "", OriginEntityApi(), LocationEntityApi(), "", arrayOf(), "", "")
}
