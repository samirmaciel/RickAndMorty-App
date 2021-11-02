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
import com.samirmaciel.rickandmortyapp.shared.model.Person
import java.util.zip.Inflater

class PersonRVadapter : ListAdapter<Person, PersonRVadapter.ViewHolder>(PersonDiffUtil()) {



    class ViewHolder(private val binding : ItemRvPersonsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindPerson(person : Person){
            binding.itemPersonName.setText(person.name)
            binding.itemPersonSpecie.setText(person.species)

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

    class PersonDiffUtil : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.name == newItem.name
        }
    }
}

