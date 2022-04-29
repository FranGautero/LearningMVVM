package com.pela.learningmvvm.data.network

import com.pela.learningmvvm.data.model.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AnimeService @Inject constructor(
    private val api:AnimeApiClient
) {

    suspend fun getAnimes():List<Data>{
        return withContext(Dispatchers.IO){
            val response = api.getAllAnimes()
            response.body()?.data ?: emptyList()
        }

    }
}