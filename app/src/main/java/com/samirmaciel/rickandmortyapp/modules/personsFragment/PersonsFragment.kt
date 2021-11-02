package com.samirmaciel.rickandmortyapp.modules.personsFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.samirmaciel.rickandmortyapp.R
import com.samirmaciel.rickandmortyapp.databinding.FragmentPersonsBinding

class PersonsFragment : Fragment(R.layout.fragment_persons) {

    private var _binding : FragmentPersonsBinding? = null
    private val binding : FragmentPersonsBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPersonsBinding.bind(view)
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}