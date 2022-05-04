package com.pela.learningmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pela.learningmvvm.R
import com.pela.learningmvvm.databinding.ActivityMainBinding
import com.pela.learningmvvm.domain.model.Anime
import com.pela.learningmvvm.ui.adapters.AnimeAdapter
import com.pela.learningmvvm.ui.viewmodel.AnimeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val animeViewModel: AnimeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animeViewModel.onCreate()

        animeViewModel.animeModel.observe(this, Observer { currentAnime ->
            initRecyclerView(currentAnime)
        })

        animeViewModel.isLoading.observe(this, Observer { isItLoading ->
            binding.progress.isVisible = isItLoading
        })

    }

    fun initRecyclerView(animeList: List<Anime>) {
        binding.rvAnimeList.layoutManager = GridLayoutManager(this, 2)
        binding.rvAnimeList.adapter = AnimeAdapter(animeList) { anime ->
            onItemSelected(anime)
        }
    }

    fun onItemSelected(anime: Anime) {
        Toast.makeText(this, anime.title, Toast.LENGTH_SHORT).show()
    }
}