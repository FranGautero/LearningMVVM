package com.pela.learningmvvm.domain

import com.pela.learningmvvm.data.AnimeRepository
import com.pela.learningmvvm.data.model.AnimesPagesResponse
import com.pela.learningmvvm.data.model.Data

//No necesario poner Use case es para dar pauta de la responsabilidad de la clase
class GetAnimesUseCase {

    private val repository = AnimeRepository()

    suspend operator fun invoke():List<Data>? = repository.getAllAnimes()

}