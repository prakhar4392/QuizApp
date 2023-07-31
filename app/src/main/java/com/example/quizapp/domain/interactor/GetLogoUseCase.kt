package com.example.quizapp.domain.interactor

import com.example.quizapp.data.model.Logo
import com.example.quizapp.domain.repository.GetLogoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetLogoUseCase(private val repository: GetLogoRepository) : BaseUseCase<Flow<List<Logo>>> {
    override suspend fun invoke() = flow {
        emit(repository.getLogo())
    }
}