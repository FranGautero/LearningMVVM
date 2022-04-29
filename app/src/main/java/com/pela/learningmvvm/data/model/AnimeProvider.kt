package com.pela.learningmvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimeProvider @Inject constructor() {
    var animes: List<Data> = emptyList()
}