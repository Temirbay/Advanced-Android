package com.example.miras.newsapp.entity

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface ContactGroupDao {

    @Query("Select * from groups where group_id=:id")
    fun getGroupById (id : Int) : Flowable<List<ContactGroup>>

    @Query("Select * from groups")
    fun getAllGroups () : Flowable<List<ContactGroup>>

    @Insert
    fun insertGroup (group: ContactGroup)
}