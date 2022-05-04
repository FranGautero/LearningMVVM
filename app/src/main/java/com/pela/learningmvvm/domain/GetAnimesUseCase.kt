package com.pela.learningmvvm.domain

import com.pela.learningmvvm.data.AnimeRepository
import com.pela.learningmvvm.data.database.entities.toDatabase
import com.pela.learningmvvm.data.model.AnimesPagesResponse
import com.pela.learningmvvm.data.model.Data
import com.pela.learningmvvm.domain.model.Anime
import javax.inject.Inject


class GetAnimesUseCase @Inject constructor(
    private val repository:AnimeRepository
) {

    suspend operator fun invoke():List<Anime> {

        val page: Int = 1
        val animes = repository.getAllAnimesFromApi(page)

        return if(animes.isNotEmpty()){
          repository.clearAnime()
          repository.insertAnime(animes.map { it.toDatabase() })
            animes
        }else{
            repository.getAllAnimesFromDb()
        }
    }

}