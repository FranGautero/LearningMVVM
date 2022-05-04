package com.pela.learningmvvm.ui.adapters

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pela.learningmvvm.R
import com.pela.learningmvvm.domain.model.Anime

class AnimeAdapter(private val animeList: List<Anime>, private val onClickListener: (Anime) -> Unit) : RecyclerView.Adapter<AnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AnimeViewHolder(layoutInflater.inflate(R.layout.anime_item, parent, false))
    }

    override fun getItemCount(): Int = animeList.size

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val item = animeList[position]
        holder.render(item, onClickListener)
    }

}