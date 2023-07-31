package com.example.quizapp

import android.app.Application
import com.example.quizapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyQuizApp: Application() {

    companion object{

        private var appInstance:MyQuizApp? = null

        fun getAppInstance():MyQuizApp{
            return appInstance!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this@MyQuizApp
        startKoin{
            androidContext(this@MyQuizApp)
            modules(appModule)
        }
    }
}