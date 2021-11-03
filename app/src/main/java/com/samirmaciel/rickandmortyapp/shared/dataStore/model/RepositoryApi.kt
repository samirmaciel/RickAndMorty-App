package com.samirmaciel.rickandmortyapp.shared.dataStore.model

import retrofit2.Call
import retrofit2.http.GET


interface RepositoryApi {

    @GET("character")
    fun getAllCharacter() : Call<ResultsResponse>

}