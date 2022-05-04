package com.pela.learningmvvm.data.network

import com.pela.learningmvvm.data.model.AnimesPagesResponse
import com.pela.learningmvvm.data.model.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AnimeService @Inject constructor(
    private val api:AnimeApiClient
) {

    suspend fun getAnimes(page: Int):AnimesPagesResponse{
        return withContext(Dispatchers.IO){
            val response = api.getAllAnimes(page)
            response.body()!!
        }

    }
}