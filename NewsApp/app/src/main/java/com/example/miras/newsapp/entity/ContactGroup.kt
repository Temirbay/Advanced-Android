package com.example.miras.newsapp.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "groups")
data class ContactGroup(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "group_id")
        val group_id : Int,

        val name : String,
        val priority : String
) : Serializable