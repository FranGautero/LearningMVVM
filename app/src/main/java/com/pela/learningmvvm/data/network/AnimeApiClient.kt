package com.pela.learningmvvm.data.network

import com.pela.learningmvvm.data.model.AnimesPagesResponse
import retrofit2.Response
import retrofit2.http.GET

interface AnimeApiClient {
    @GET("now")
    suspend fun getAllAnimes():Response<AnimesPagesResponse>
}