package com.example.miras.newsapp

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.example.miras.newsapp.entity.ContactDatabase
import com.example.miras.newsapp.storage.RoomStorage
import com.example.miras.newsapp.storage.RoomStorageImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration




val appModule = module {

    single { createRoomStorage(androidContext())}
    single { RoomStorageImpl(get()) as RoomStorage }

}

fun createRoomStorage (context : Context) : ContactDatabase {
    return Room.databaseBuilder(context, ContactDatabase::class.java, "contactDB")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
}
