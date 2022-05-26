package com.pela.learningmvvm.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.pela.learningmvvm.data.network.AnimeService
import com.pela.learningmvvm.data.paging.AnimePagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(

    private val service: AnimeService

) : ViewModel() {


    val flow = Pager(
        PagingConfig(pageSize = 1)
    ) {
        AnimePagingSource(service)
    }.flow
        .cachedIn(viewModelScope)

}

