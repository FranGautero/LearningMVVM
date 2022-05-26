package com.pela.learningmvvm.ui.adapters


import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pela.learningmvvm.databinding.AnimeItemBinding
import com.pela.learningmvvm.domain.model.Anime

class AnimeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = AnimeItemBinding.bind(view)


    fun render(animeModel: Anime, onClickListener: (Anime) -> Unit) {

        binding.tvTitle.text = animeModel.title
        binding.tvScore.text = animeModel.score
        Glide.with(binding.ivAnime.context).load(animeModel.image).into(binding.ivAnime)
        itemView.setOnClickListener {
            onClickListener(animeModel)
        }
    }
}