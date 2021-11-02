package com.samirmaciel.rickandmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.samirmaciel.rickandmortyapp.databinding.ActivityMainBinding
import com.samirmaciel.rickandmortyapp.shared.adapter.EpisodeRVadapter
import com.samirmaciel.rickandmortyapp.shared.model.Episode

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var rvAdapter : EpisodeRVadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initRecyclerview()
    }

    override fun onResume() {
        super.onResume()

        val listEpisodes = arrayListOf<Episode>(
            Episode("Pilot", "December 2, 2013", "S01E01", arrayOf("https", "https") ),
            Episode("Lawnmower Dog", "December 2, 2013", "S01E02", arrayOf("https", "https") ),
            Episode("Anatomy Park", "December 2, 2013", "S01E03", arrayOf("https", "https") ),
            Episode("M. Night Shaym-Aliens!", "December 2, 2013", "S01E04", arrayOf("https", "https") ),
            Episode("Meeseeks and Destroy", "December 2, 2013", "S01E05", arrayOf("https", "https") ),
        )

        rvAdapter.submitList(listEpisodes)
    }

    private fun initRecyclerview(){
        rvAdapter = EpisodeRVadapter()
        binding.rvEpisodes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvEpisodes.adapter = rvAdapter
    }
}