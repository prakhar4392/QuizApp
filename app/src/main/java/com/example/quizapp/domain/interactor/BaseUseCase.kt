package com.example.quizapp.domain.interactor

interface BaseUseCase<out Result> {

    suspend operator fun invoke():Result
}