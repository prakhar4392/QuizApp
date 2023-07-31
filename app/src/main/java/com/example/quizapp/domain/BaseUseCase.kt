package com.example.quizapp.domain

interface BaseUseCase<out Result> {

    suspend operator fun invoke():Result
}