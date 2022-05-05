package com.pela.learningmvvm.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pela.learningmvvm.data.AnimeRepository
import com.pela.learningmvvm.data.network.AnimeService
import com.pela.learningmvvm.domain.model.Anime
import com.pela.learningmvvm.domain.model.toDomain

class AnimePagingSource(
    val api: AnimeService
): PagingSource<Int, Anime>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
        return try{
            val page = params.key ?: 1
            val animeResponse = api.getAnimes(page)
//            for (i in animeResponse.data.indices){
//                if(animeResponse.data[i].title == "Yu☆Gi☆Oh!: Go Rush!!"){
//                   animeResponse.data.drop(i)
//                }
//            }
            val animes = animeResponse.data.map {

                it.toDomain()
            }
            val test = animes
            LoadResult.Page(
                data = animes,
                prevKey = null,
                nextKey = page + 1
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