package com.pela.learningmvvm.data

import com.pela.learningmvvm.data.model.AnimeProvider
import com.pela.learningmvvm.data.model.AnimesPagesResponse
import com.pela.learningmvvm.data.model.Data
import com.pela.learningmvvm.data.network.AnimeService

class AnimeRepository {

    private val api = AnimeService()

    suspend fun getAllAnimes(): List<Data>{
        val response: List<Data> = api.getAnimes()
        AnimeProvider.animes = response
        return response
    }
}