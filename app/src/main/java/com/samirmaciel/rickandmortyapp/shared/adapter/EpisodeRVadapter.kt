package com.samirmaciel.rickandmortyapp.shared.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.samirmaciel.rickandmortyapp.databinding.ItemRvEpisodesBinding
import com.samirmaciel.rickandmortyapp.shared.model.Episode
import com.samirmaciel.rickandmortyapp.shared.model.Person

class EpisodeRVadapter : ListAdapter<Episode, EpisodeRVadapter.ViewHolder>(EpisodeRVadapter.EpisodeDiffiUtil()) {


    class ViewHolder(private val binding : ItemRvEpisodesBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindEpisode(episode : Episode){
            binding.itemEpisodeName.setText(episode.name)
            binding.itemEpisodeNumber.setText(episode.episode)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRvEpisodesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindEpisode(getItem(position))
    }

    class EpisodeDiffiUtil : DiffUtil.ItemCallback<Episode>(){

        override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem.episode == newItem.episode
        }

        override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem.episode == newItem.episode
        }
    }
}