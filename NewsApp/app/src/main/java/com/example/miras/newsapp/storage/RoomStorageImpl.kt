package com.example.miras.newsapp.storage

import com.example.miras.newsapp.entity.News
import com.example.miras.newsapp.entity.NewsDatabase
import com.example.miras.newsapp.storage.RoomStorage
import io.reactivex.Observable


class RoomStorageImpl(private val database : NewsDatabase) : RoomStorage {


    override fun getNews(): Observable<ArrayList<News>> {

        return database.newsDao().getAllNews()
                .map { it as ArrayList<News> }
                .toObservable()
    }

    override fun insertNews(news: News) {
        database.newsDao().insertNews(news)
    }

}