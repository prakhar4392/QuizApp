package com.example.quizapp.domain

import com.example.quizapp.data.Logo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetLogoUseCase(private val repository: GetLogoRepository) : BaseUseCase<Flow<List<Logo>>>{
    override suspend fun invoke() = flow {
        emit(repository.getLogo())
    }
}