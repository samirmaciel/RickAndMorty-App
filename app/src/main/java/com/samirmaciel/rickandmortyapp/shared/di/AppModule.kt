package com.samirmaciel.rickandmortyapp.shared.di


import com.samirmaciel.rickandmortyapp.modules.personsFragment.PersonsFragmentViewModel
import com.samirmaciel.rickandmortyapp.shared.dataStore.model.ApiService
import com.samirmaciel.rickandmortyapp.shared.dataStore.model.RepositoryApi
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {(rp: RepositoryApi) -> PersonsFragmentViewModel(rp) }

}


val repositoryModule = module {
    single { ApiService.getInstance().create(RepositoryApi::class.java) }
}
