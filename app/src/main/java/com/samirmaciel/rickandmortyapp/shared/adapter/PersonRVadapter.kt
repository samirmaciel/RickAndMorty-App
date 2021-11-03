package com.samirmaciel.rickandmortyapp.shared.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.samirmaciel.rickandmortyapp.R
import com.samirmaciel.rickandmortyapp.databinding.ItemRvPersonsBinding
import com.samirmaciel.rickandmortyapp.shared.dataStore.model.PersonEntityApi
import com.samirmaciel.rickandmortyapp.shared.model.Person
import java.util.zip.Inflater

class PersonRVadapter : ListAdapter<PersonEntityApi, PersonRVadapter.ViewHolder>(PersonDiffUtil()) {



    class ViewHolder(private val binding : ItemRvPersonsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindPerson(person : PersonEntityApi){
            binding.itemPersonName.setText(person.name)

            Glide.with(binding.personCardView).load(person.image).transition(DrawableTransitionOptions.withCrossFade()).into(binding.itemPersonImage)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvPersonsBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPerson(getItem(position))

    }

    class PersonDiffUtil : DiffUtil.ItemCallback<PersonEntityApi>() {
        override fun areItemsTheSame(oldItem: PersonEntityApi, newItem: PersonEntityApi): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: PersonEntityApi, newItem: PersonEntityApi): Boolean {
            return oldItem.name == newItem.name
        }
    }
}

