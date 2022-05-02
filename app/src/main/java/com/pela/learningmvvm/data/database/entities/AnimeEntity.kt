package com.pela.learningmvvm.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pela.learningmvvm.domain.model.Anime

@Entity(tableName = "anime_table")
data class AnimeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "synopsis") val synopsis: String,
    @ColumnInfo(name = "score") val score: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "episodes") val episodes: String,
    @ColumnInfo(name = "broadcast") val broadcast: String,
    @ColumnInfo(name = "rank") val rank: String,
    @ColumnInfo(name = "popularity") val popularity: String,


    )

fun Anime.toDatabase(): AnimeEntity {
    return AnimeEntity(
        title = title,
        image = image,
        synopsis = synopsis,
        score = score,
        status = status,
        episodes = episodes,
        broadcast = broadcast,
        rank = rank,
        popularity = popularity
    )
}
