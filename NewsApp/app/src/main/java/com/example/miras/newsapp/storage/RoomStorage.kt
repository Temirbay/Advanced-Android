package com.example.miras.newsapp.storage

import com.example.miras.newsapp.entity.News
import io.reactivex.Observable


interface RoomStorage {
    fun getNews () : Observable<ArrayList<News>>
    fun insertNews (news : News)
}