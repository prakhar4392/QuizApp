package com.example.quizapp.di

import com.example.quizapp.data.repository.GetLogoRepositoryImpl
import com.example.quizapp.domain.repository.GetLogoRepository
import com.example.quizapp.domain.interactor.GetLogoUseCase
import com.example.quizapp.presentation.viewmodel.GetLogoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

        factory { GetLogoUseCase(get()) }

        viewModel { GetLogoViewModel(get()) }

        factory<GetLogoRepository> { GetLogoRepositoryImpl() }
}