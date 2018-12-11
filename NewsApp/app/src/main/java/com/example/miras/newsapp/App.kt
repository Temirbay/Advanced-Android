package com.example.miras.newsapp

import android.annotation.SuppressLint
import android.app.Application
import android.arch.persistence.room.Room
import com.example.miras.newsapp.contact.contactApp
import com.example.miras.newsapp.entity.ContactDatabase
import com.example.miras.newsapp.entity.ContactGroup
import org.koin.android.ext.android.startKoin

class App : Application() {

    @SuppressLint("CheckResult")
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule, contactApp))

        val database = Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "contactDB")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

        database.contactGroupsDao().getAllGroups().subscribe {
            if (it.isEmpty()) {
                database.contactGroupsDao()
                        .insertGroup(ContactGroup(0, "Default", "0"))
                database.contactGroupsDao()
                        .insertGroup(ContactGroup(0, "Friend", "1"))
                database.contactGroupsDao()
                        .insertGroup(ContactGroup(0, "Colleague", "1"))
                database.contactGroupsDao()
                        .insertGroup(ContactGroup(0, "Family", "2"))
            }
        }
    }
}