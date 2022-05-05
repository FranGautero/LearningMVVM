package com.pela.learningmvvm.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.pela.learningmvvm.data.database.dao.AnimeDao
import com.pela.learningmvvm.data.database.entities.AnimeEntity
import com.pela.learningmvvm.data.model.AnimeProvider
import com.pela.learningmvvm.data.model.AnimesPagesResponse
import com.pela.learningmvvm.data.model.Data
import com.pela.learningmvvm.data.network.AnimeService
import com.pela.learningmvvm.data.paging.AnimePagingSource
import com.pela.learningmvvm.domain.model.Anime
import com.pela.learningmvvm.domain.model.toDomain
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val api : AnimeService,
    private val animeDao: AnimeDao
) {

    fun getSearchAnimes(): Flow<PagingData<Anime>>{
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { AnimePagingSource(api)}
        ).flow
    }

    suspend fun getAllAnimesFromApi(page: Int): List<Anime>{
        val response: AnimesPagesResponse = api.getAnimes(page)
        return response.data.map { it.toDomain() }
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

    companion object {
        const val NETWORK_PAGE_SIZE = 1
    }
}