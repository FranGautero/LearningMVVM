package com.pela.learningmvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pela.learningmvvm.data.database.dao.AnimeDao
import com.pela.learningmvvm.data.database.entities.AnimeEntity

@Database(entities = [AnimeEntity::class], version = 1)
abstract class AnimeDatabase: RoomDatabase() {
    abstract fun animeDao(): AnimeDao
}
