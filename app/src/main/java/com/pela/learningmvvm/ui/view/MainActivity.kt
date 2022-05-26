package com.pela.learningmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pela.learningmvvm.R
import com.pela.learningmvvm.databinding.ActivityMainBinding
import com.pela.learningmvvm.domain.model.Anime
import com.pela.learningmvvm.ui.adapters.AnimeAdapter
import com.pela.learningmvvm.ui.viewmodel.AnimeViewModel

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val animeViewModel: AnimeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvAnimeList.layoutManager = GridLayoutManager(this, 2)
        val pagingAdapter = AnimeAdapter() { anime ->
            onItemSelected(anime)
        }
        binding.rvAnimeList.adapter = pagingAdapter


        lifecycleScope.launch {
            animeViewModel.flow.collectLatest {
                pagingAdapter.submitData(it)
            }
        }

    }

    private fun onItemSelected(anime: Anime) {
        Toast.makeText(this, anime.title, Toast.LENGTH_SHORT).show()
    }

}