package com.example.quizapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.data.Logo
import com.example.quizapp.domain.GetLogoUseCase

class GetLogoViewModel(private val getLogoUseCase: GetLogoUseCase): ViewModel() {

    private val _logoLiveData = MutableLiveData<List<Logo>>()

    val logoLiveData:LiveData<List<Logo>>
        get() = _logoLiveData

    suspend fun getLogoData(){
        getLogoUseCase.invoke().collect{
            _logoLiveData.value = it
        }
    }
}