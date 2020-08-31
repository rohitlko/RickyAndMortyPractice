package com.example.rickyandmortypractice.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickyandmortypractice.R
import com.example.rickyandmortypractice.model.Character
import kotlinx.android.synthetic.main.item_characters.view.episodes_char
import kotlinx.android.synthetic.main.item_characters.view.id_char
import kotlinx.android.synthetic.main.item_characters.view.image_char
import kotlinx.android.synthetic.main.item_characters.view.name_char
import kotlinx.android.synthetic.main.item_footer.view.footer

class CharacterAdapter(private val context: Context, private val characterList: List<Character>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_CONTENT) {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_characters, parent, false)
            CharacterViewHolder(itemView)
        } else {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_footer, parent, false)
            CharacterFooterViewHolder(itemView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = characterList[position]
        if (getItemViewType(position) == VIEW_TYPE_CONTENT) {
            holder as CharacterViewHolder
            holder.bind(currentItem)
        } else {
            holder as CharacterFooterViewHolder
            holder.footer.text = "rohitTestFooter"
        }
    }

    override fun getItemCount(): Int {
        return if (characterList.size >= MAX_API_CHARACTER_COUNT + 1) {
            characterList.size + 1
        } else {
            characterList.size
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position >= MAX_API_CHARACTER_COUNT - 1) {
            VIEW_TYPE_FOOTER
        } else {
            VIEW_TYPE_CONTENT
        }
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(currentItem: Character) {
            itemView.id_char.text = currentItem.id.toString()
            itemView.name_char.text = currentItem.name
            itemView.episodes_char.text = currentItem.episode.toString()
            Glide.with(context).load(currentItem.image).into(itemView.image_char)
        }
    }

    inner class CharacterFooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val footer: TextView = itemView.footer
    }

    companion object {
        const val MAX_API_CHARACTER_COUNT = 20
        const val VIEW_TYPE_CONTENT = 1
        const val VIEW_TYPE_FOOTER = 2
    }
}

