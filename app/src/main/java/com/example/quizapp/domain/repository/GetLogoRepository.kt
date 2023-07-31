package com.example.quizapp.domain.repository

import com.example.quizapp.data.model.Logo

interface GetLogoRepository {

    suspend fun getLogo():List<Logo>
}