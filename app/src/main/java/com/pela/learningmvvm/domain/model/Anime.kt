package com.pela.learningmvvm.domain.model

import com.pela.learningmvvm.data.database.entities.AnimeEntity
import com.pela.learningmvvm.data.model.Data


data class Anime(
    val title: String,
    val image: String,
    val synopsis: String,
    val score: String,
    val status: String,
    val episodes: String,
    val broadcast: String,
    val rank: String,
    val popularity: String,
)

fun Data.toDomain() = Anime(
    title = title,
    image = images.jpg.image_url,
    synopsis = "$synopsis",
    score = score.toString(),
    status = status,
    episodes = episodes.toString(),
    broadcast = broadcast.string,
    rank = rank.toString(),
    popularity = popularity.toString()
)

fun AnimeEntity.toDomain() = Anime(
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