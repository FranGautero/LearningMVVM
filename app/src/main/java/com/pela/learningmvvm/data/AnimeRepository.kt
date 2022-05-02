package com.pela.learningmvvm.data

import com.pela.learningmvvm.data.database.dao.AnimeDao
import com.pela.learningmvvm.data.database.entities.AnimeEntity
import com.pela.learningmvvm.data.model.AnimeProvider
import com.pela.learningmvvm.data.model.AnimesPagesResponse
import com.pela.learningmvvm.data.model.Data
import com.pela.learningmvvm.data.network.AnimeService
import com.pela.learningmvvm.domain.model.Anime
import com.pela.learningmvvm.domain.model.toDomain
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val api : AnimeService,
    private val animeDao: AnimeDao
) {



    suspend fun getAllAnimesFromApi(): List<Anime>{
        val response: List<Data> = api.getAnimes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllAnimesFromDb(): List<Anime>{
        val response: List<AnimeEntity> = animeDao.getAllAnime()
        return response.map { it.toDomain() }
    }

    suspend fun insertAnime(anime: List<AnimeEntity>){
        animeDao.insertAll(anime)
    }

    suspend fun clearAnime(){
        animeDao.deleteAll()
    }
}