package com.example.miras.newsapp.entity

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable


@Dao
interface NewsDAO {

    @Query("Select * from news")
    fun getAllNews () : Flowable<List<News>>

    @Insert
    fun insertNews (news : News)

    @Query("Delete from news")
    fun nukeTable ()

}