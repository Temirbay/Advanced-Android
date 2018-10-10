package com.example.miras.newsapp

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.example.miras.newsapp.entity.NewsDatabase
import com.example.miras.newsapp.storage.LocalStorage
import com.example.miras.newsapp.storage.LocalStorageImpl
import com.example.miras.newsapp.storage.RoomStorage
import com.example.miras.newsapp.storage.RoomStorageImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module


val appModule = module {
    single { createSharedPrefs(androidContext()) }
    single { LocalStorageImpl(get()) as LocalStorage }

    single { createRoomStorage(androidContext())}
    single { RoomStorageImpl(get()) as RoomStorage }


}

fun createSharedPrefs (context : Context) : SharedPreferences {
    return context.applicationContext.getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)
}

fun createRoomStorage (context : Context) : NewsDatabase {
    return Room.databaseBuilder(context, NewsDatabase::class.java, "newsDB")
            .allowMainThreadQueries()
            .build()
}