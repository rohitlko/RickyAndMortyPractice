package com.example.rickyandmortypractice.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickyandmortypractice.R
import com.example.rickyandmortypractice.model.Character
import kotlinx.android.synthetic.main.item_characters.view.episodes_char
import kotlinx.android.synthetic.main.item_characters.view.id_char
import kotlinx.android.synthetic.main.item_characters.view.name_char

class CharacterAdapter(private val characterList: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_characters, parent, false)
        return CharacterViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val currentItem = characterList[position]
        //holder.imageView.(currentItem.image).
        holder.idView.text = currentItem.id.toString()
        holder.nameView.text = currentItem.name
        holder.episodeView.text = currentItem.episode.toString()
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // val imageView : ImageView = itemView.image_char
        val idView: TextView = itemView.id_char
        val nameView: TextView = itemView.name_char
        val episodeView: TextView = itemView.episodes_char


    }
}

