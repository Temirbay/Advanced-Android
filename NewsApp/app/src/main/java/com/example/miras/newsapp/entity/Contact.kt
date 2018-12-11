package com.example.miras.newsapp.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "contacts"/*,
        foreignKeys = [ForeignKey(entity = Contact::class,
        parentColumns = arrayOf("group_id"),
        childColumns = arrayOf("contact_id"),
        onDelete = ForeignKey.CASCADE)]*/)

data class Contact(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "contact_id")
        val contact_id : Int,

        val name : String,
        val mobile_phone : String,
        val home_phone : String,
        val work_phone : String,
        val photo : String,
        val contact_group_id : Int

) : Serializable

