package com.example.quizapp.di

import com.example.quizapp.data.GetLogoRepositoryImpl
import com.example.quizapp.domain.GetLogoRepository
import com.example.quizapp.domain.GetLogoUseCase
import com.example.quizapp.presentation.GetLogoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

        factory { GetLogoUseCase(get()) }

        viewModel { GetLogoViewModel(get()) }

        factory<GetLogoRepository> { GetLogoRepositoryImpl() }
}