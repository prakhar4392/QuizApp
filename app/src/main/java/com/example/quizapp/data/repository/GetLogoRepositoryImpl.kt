package com.example.quizapp.data.repository

import com.example.quizapp.MyQuizApp
import com.example.quizapp.data.model.Logo
import com.example.quizapp.data.model.LogoData
import com.example.quizapp.domain.repository.GetLogoRepository
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class GetLogoRepositoryImpl : GetLogoRepository {
    override suspend fun getLogo(): List<Logo> {
        val i: InputStream = MyQuizApp.getAppInstance().assets.open("logo.json")
        val br = BufferedReader(InputStreamReader(i))
        val response: LogoData = Gson().fromJson(br, LogoData::class.java)
        return response.data
    }
}