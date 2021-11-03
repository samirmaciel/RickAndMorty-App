package com.samirmaciel.rickandmortyapp.modules.personsFragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.samirmaciel.rickandmortyapp.R
import com.samirmaciel.rickandmortyapp.databinding.FragmentPersonsBinding
import com.samirmaciel.rickandmortyapp.shared.adapter.PersonRVadapter
import com.samirmaciel.rickandmortyapp.shared.dataStore.model.ApiService
import com.samirmaciel.rickandmortyapp.shared.dataStore.model.RepositoryApi
import com.samirmaciel.rickandmortyapp.shared.model.Location
import com.samirmaciel.rickandmortyapp.shared.model.Origin
import com.samirmaciel.rickandmortyapp.shared.model.Person

class PersonsFragment : Fragment(R.layout.fragment_persons) {

    private var _binding : FragmentPersonsBinding? = null
    private val binding : FragmentPersonsBinding get() = _binding!!
    lateinit var recyclerAdapter : PersonRVadapter

    private val viewModel : PersonsFragmentViewModel by activityViewModels{
        PersonsFragmentViewModel.ViewModelFactory(ApiService.getInstance().create(RepositoryApi::class.java))
    }

    override fun onResume() {
        super.onResume()
        initRecycler()

        val list = mutableListOf<Person>().apply {
            add(Person(1,
                "Rick",
                "Vivo",
                "Humano",
                Origin("Terra", "https"),
                Location("USA", "Https"),
                "Masculino",
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                arrayOf("S01", "S24")))

             add(Person(2,
                    "Morty Smith",
                    "Vivo",
                    "Humano",
                    Origin("Terra", "https"),
                    Location("USA", "Https"),
                    "Masculino",
                    "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
                    arrayOf("S01", "S24")))

                add(Person(3,
                    "Bepisian",
                    "Vivo",
                    "Humano",
                    Origin("Terra", "https"),
                    Location("USA", "Https"),
                    "Masculino",
                    "https://rickandmortyapi.com/api/character/avatar/35.jpeg",
                    arrayOf("S01", "S24")))

        }

        viewModel.listPersons.observe(this){
            Log.d("DANY", "onResume: " + it.size)
            recyclerAdapter.submitList(it)
        }




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPersonsBinding.bind(view)


    }




    private fun initRecycler(){
        recyclerAdapter = PersonRVadapter()
        binding.rvPersons.setHasFixedSize(true)
        binding.rvPersons.adapter = recyclerAdapter
        binding.rvPersons.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}