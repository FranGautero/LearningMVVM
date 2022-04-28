package com.pela.learningmvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/seasons/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}