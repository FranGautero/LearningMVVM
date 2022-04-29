package com.pela.learningmvvm.domain

import com.pela.learningmvvm.data.model.AnimeProvider
import com.pela.learningmvvm.data.model.Data
import javax.inject.Inject

class GetRandomAnimeUseCase @Inject constructor(
    private val animeProvider: AnimeProvider
) {

    operator fun invoke(): Data?{
        val animes = animeProvider.animes
        if(!animes.isNullOrEmpty()){
            val randomNumber = (animes.indices).random()
            return animes[randomNumber]
        }
        return null
    }

}