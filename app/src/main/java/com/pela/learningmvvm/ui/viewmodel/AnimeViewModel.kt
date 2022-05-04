package com.pela.learningmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.pela.learningmvvm.R
import com.pela.learningmvvm.domain.GetAnimesUseCase
import com.pela.learningmvvm.domain.model.Anime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val getAnimesUseCase:GetAnimesUseCase,

) : ViewModel() {

    val animeModel = MutableLiveData<List<Anime>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAnimesUseCase()
            if(!result.isNullOrEmpty()){
                animeModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }






}