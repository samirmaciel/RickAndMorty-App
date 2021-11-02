package com.samirmaciel.rickandmortyapp.shared.model

data class Person(

    val id : Long,
    val name : String,
    val status : String,
    val species : String,
    val origin : Origin,
    val location: Location,
    val gender : String,
    val image : String,
    val episode : Array<String>
)
