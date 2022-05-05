package com.pela.learningmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.recyclerview.widget.RecyclerView
import com.pela.learningmvvm.R
import com.pela.learningmvvm.data.network.AnimeService
import com.pela.learningmvvm.data.paging.AnimePagingSource
import com.pela.learningmvvm.domain.GetAnimesUseCase
import com.pela.learningmvvm.domain.model.Anime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val getAnimesUseCase:GetAnimesUseCase,
    private val service: AnimeService

) : ViewModel() {

//    val animeModel = MutableLiveData<Flow<PagingData<Anime>>>()
    val isLoading = MutableLiveData<Boolean>()
//
//
//
//    fun onCreate(){
//        viewModelScope.launch {
//            isLoading.postValue(true)
//            val result = getAnimesUseCase()
//                animeModel.postValue(result)
//                isLoading.postValue(false)
//
//        }
//    }
val flow = Pager(
    PagingConfig(pageSize = 1)
) {
    AnimePagingSource(service)
}.flow
    .cachedIn(viewModelScope)





}

