package com.pela.learningmvvm.domain

import com.pela.learningmvvm.data.model.AnimeProvider
import com.pela.learningmvvm.data.model.Data

class GetRandomAnimeUseCase {

    operator fun invoke(): Data?{
        val animes = AnimeProvider.animes
        if(!animes.isNullOrEmpty()){
            val randomNumber = (animes.indices).random()
            return animes[randomNumber]
        }
        return null
    }

}