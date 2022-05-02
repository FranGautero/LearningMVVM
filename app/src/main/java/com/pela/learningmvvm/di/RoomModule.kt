package com.pela.learningmvvm.di

import android.content.Context
import androidx.room.Room
import com.pela.learningmvvm.data.database.AnimeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "anime_database"

    @Singleton
    @Provides
    fun providesRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, AnimeDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideAnimeDao(database: AnimeDatabase) = database.animeDao()
}