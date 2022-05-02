package com.pela.learningmvvm.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pela.learningmvvm.data.database.entities.AnimeEntity

@Dao
interface AnimeDao {
    @Query("SELECT * FROM anime_table")
    suspend fun getAllAnime(): List<AnimeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(anime: List<AnimeEntity>)

    @Query("DELETE FROM anime_table")
    suspend fun deleteAll()
}