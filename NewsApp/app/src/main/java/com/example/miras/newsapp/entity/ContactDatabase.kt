package com.example.miras.newsapp.entity

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


@Database(entities = [Contact::class, ContactGroup::class], version = 4, exportSchema = false)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDao
    abstract fun contactGroupsDao() : ContactGroupDao
}