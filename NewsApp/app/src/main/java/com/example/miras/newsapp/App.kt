package com.example.miras.newsapp

import android.app.Application
import com.example.miras.newsapp.auth.loginApp
import com.example.miras.newsapp.news.newsApp
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule, newsApp, loginApp))
    }
}