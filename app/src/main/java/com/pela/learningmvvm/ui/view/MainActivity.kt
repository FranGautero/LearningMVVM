package com.pela.learningmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.pela.learningmvvm.databinding.ActivityMainBinding
import com.pela.learningmvvm.ui.viewmodel.AnimeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val animeViewModel : AnimeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animeViewModel.onCreate()

        animeViewModel.animeModel.observe(this, Observer { currentAnime ->
            binding.animeTitle.text = currentAnime.title
            binding.animeSyn.text = currentAnime.synopsis
        })

        animeViewModel.isLoading.observe(this, Observer { isItLoading ->
            binding.progress.isVisible = isItLoading
        })

        binding.viewContainer.setOnClickListener(){
            animeViewModel.randomAnime()
        }
    }
}