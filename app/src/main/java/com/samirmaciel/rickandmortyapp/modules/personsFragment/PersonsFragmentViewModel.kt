package com.samirmaciel.rickandmortyapp.modules.personsFragment

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.samirmaciel.rickandmortyapp.shared.dataStore.model.PersonEntityApi
import com.samirmaciel.rickandmortyapp.shared.dataStore.model.RepositoryApi
import com.samirmaciel.rickandmortyapp.shared.dataStore.model.ResultsResponse
import com.samirmaciel.rickandmortyapp.shared.model.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonsFragmentViewModel(private val repository : RepositoryApi) : ViewModel(){

    var listPersons : MutableLiveData<MutableList<PersonEntityApi>> = MutableLiveData()


    init {
        getAllPersons()
    }

    fun getAllPersons(){
        viewModelScope.launch{
            repository.getAllCharacter().enqueue(object : Callback<ResultsResponse>{
                override fun onResponse(
                    call: Call<ResultsResponse>,
                    response: Response<ResultsResponse>
                ) {
                    listPersons.postValue(response.body()?.personsList)
                }

                override fun onFailure(call: Call<ResultsResponse>, t: Throwable) {

                }

            })
        }
    }


    class ViewModelFactory(private val repositoryApi: RepositoryApi) : ViewModelProvider.Factory{

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return PersonsFragmentViewModel(repositoryApi) as T
        }


    }
}