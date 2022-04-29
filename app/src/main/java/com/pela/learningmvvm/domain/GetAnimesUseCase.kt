package com.pela.learningmvvm.domain

import com.pela.learningmvvm.data.AnimeRepository
import com.pela.learningmvvm.data.model.AnimesPagesResponse
import com.pela.learningmvvm.data.model.Data
import javax.inject.Inject


class GetAnimesUseCase @Inject constructor(
    private val repository:AnimeRepository
) {

    suspend operator fun invoke():List<Data>? = repository.getAllAnimes()

}