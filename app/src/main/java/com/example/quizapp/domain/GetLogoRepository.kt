package com.example.quizapp.domain

import com.example.quizapp.data.Logo

interface GetLogoRepository {

    suspend fun getLogo():List<Logo>
}