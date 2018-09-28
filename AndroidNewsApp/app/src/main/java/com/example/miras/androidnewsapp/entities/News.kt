package com.example.miras.androidnewsapp.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
        val title : String,
        val date : String,
        val content : String,
        val imageUrl : String) : Parcelable