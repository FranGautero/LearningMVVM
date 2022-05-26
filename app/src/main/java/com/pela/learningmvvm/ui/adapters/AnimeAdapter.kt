package com.pela.learningmvvm.ui.adapters

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pela.learningmvvm.R
import com.pela.learningmvvm.domain.model.Anime

class AnimeAdapter(private val onClickListener: (Anime) -> Unit) :
    PagingDataAdapter<Anime, AnimeViewHolder>(ANIME_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AnimeViewHolder(layoutInflater.inflate(R.layout.anime_item, parent, false))
    }


    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val item = getItem(position)
        holder.render(item!!, onClickListener)
    }

    companion object {
        private val ANIME_COMPARATOR = object : DiffUtil.ItemCallback<Anime>() {
            override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean =
                oldItem == newItem
        }

    }
}