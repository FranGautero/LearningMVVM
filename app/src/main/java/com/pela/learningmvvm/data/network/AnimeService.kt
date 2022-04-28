package com.pela.learningmvvm.data.network

import com.pela.learningmvvm.core.RetrofitHelper
import com.pela.learningmvvm.data.model.AnimesPagesResponse
import com.pela.learningmvvm.data.model.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimeService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAnimes():List<Data>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(AnimeApiClient::class.java).getAllAnimes()
            response.body()?.data ?: emptyList()
        }

    }
}