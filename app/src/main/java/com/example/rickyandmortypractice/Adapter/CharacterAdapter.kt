package com.example.rickyandmortypractice.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickyandmortypractice.R
import com.example.rickyandmortypractice.model.Character
import kotlinx.android.synthetic.main.item_characters.view.episodes_char
import kotlinx.android.synthetic.main.item_characters.view.id_char
import kotlinx.android.synthetic.main.item_characters.view.image_char
import kotlinx.android.synthetic.main.item_characters.view.name_char

class CharacterAdapter(private val context: Context, private val characterList: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_characters, parent, false)
        return CharacterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentItem = characterList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(currentItem: Character) {
            itemView.id_char.text = currentItem.id.toString()
            itemView.name_char.text = currentItem.name
            itemView.episodes_char.text = currentItem.episode.toString()
            Glide.with(context).load(currentItem.image).into(itemView.image_char)
        }
    }
}

