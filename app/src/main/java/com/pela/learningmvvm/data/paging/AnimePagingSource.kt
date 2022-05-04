package com.pela.learningmvvm.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pela.learningmvvm.data.AnimeRepository
import com.pela.learningmvvm.domain.model.Anime

class AnimePagingSource(
    val animeRepository: AnimeRepository
): PagingSource<Int, Anime>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
        return try{
            val animeList = animeRepository.getAllAnimesFromApi(params.key ?: 1)
            LoadResult.Page(
                data = animeList,
                prevKey = null,
                nextKey = animeList.size
            )
        } catch(e: Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Anime>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1)?: anchorPage?.nextKey?.minus(1)
        }
    }

}