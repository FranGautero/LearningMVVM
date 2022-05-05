package com.pela.learningmvvm.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.pela.learningmvvm.data.database.AnimeDatabase
import com.pela.learningmvvm.data.network.AnimeService
import com.pela.learningmvvm.domain.model.Anime

@OptIn(ExperimentalPagingApi::class)
class AnimeRemoteMediator(
    val service: AnimeService,
    val animeDatabase: AnimeDatabase
): RemoteMediator<Int, Anime>() {
    override suspend fun load(loadType: LoadType, state: PagingState<Int, Anime>): MediatorResult {
        TODO("Not yet implemented")
    }

}