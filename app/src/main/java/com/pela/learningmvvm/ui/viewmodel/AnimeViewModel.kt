package com.pela.learningmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pela.learningmvvm.data.model.Data
import com.pela.learningmvvm.domain.GetAnimesUseCase
import com.pela.learningmvvm.domain.GetRandomAnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val getAnimesUseCase:GetAnimesUseCase,
    private val getRandomAnimeUseCase: GetRandomAnimeUseCase
) : ViewModel() {

    val animeModel = MutableLiveData<Data>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAnimesUseCase()
            if(!result.isNullOrEmpty()){
                animeModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomAnime(){
        isLoading.postValue(true)
        val anime = getRandomAnimeUseCase()
        if(anime!=null){
            animeModel.postValue(anime)
        }

        isLoading.postValue(false)

    }


}