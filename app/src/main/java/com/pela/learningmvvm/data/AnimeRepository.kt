package com.pela.learningmvvm.data

import com.pela.learningmvvm.data.model.AnimeProvider
import com.pela.learningmvvm.data.model.AnimesPagesResponse
import com.pela.learningmvvm.data.model.Data
import com.pela.learningmvvm.data.network.AnimeService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val api : AnimeService,
    private val animeProvider: AnimeProvider
) {



    suspend fun getAllAnimes(): List<Data>{
        val response: List<Data> = api.getAnimes()
        animeProvider.animes = response
        return response
    }
}