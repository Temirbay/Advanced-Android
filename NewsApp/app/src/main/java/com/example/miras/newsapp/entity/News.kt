package com.example.miras.newsapp.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "news")
data class News(
        @PrimaryKey(autoGenerate = true)
        val id : Int,
        val title : String,
        val date : String,
        val content : String,
        val imageUrl : String
) : Serializable