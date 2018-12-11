package com.example.miras.newsapp.entity

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable


@Dao
interface ContactDao {

    @Query("Select * from contacts")
    fun getContacts () : Flowable<List<Contact>>

    @Insert
    fun insertContact (contact : Contact)

    @Query("Delete from contacts")
    fun nukeTable ()

}