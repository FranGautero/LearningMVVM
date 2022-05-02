package com.pela.learningmvvm.domain

import com.pela.learningmvvm.data.AnimeRepository
import com.pela.learningmvvm.data.model.AnimeProvider
import com.pela.learningmvvm.data.model.Data
import com.pela.learningmvvm.domain.model.Anime
import javax.inject.Inject

class GetRandomAnimeUseCase @Inject constructor(
    private val repository: AnimeRepository
) {

    suspend operator fun invoke(): Anime?{
        val animes = repository.getAllAnimesFromDb()
        if(!animes.isNullOrEmpty()){
            val randomNumber = (animes.indices).random()
            return animes[randomNumber]
        }
        return null
    }

}