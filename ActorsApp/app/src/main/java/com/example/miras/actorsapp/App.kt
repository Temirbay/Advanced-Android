package com.example.miras.actorsapp

import android.app.Application
import com.example.miras.actorsapp.actor.actorApp
import org.koin.android.ext.android.startKoin

class App : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(actorApp))
    }

}