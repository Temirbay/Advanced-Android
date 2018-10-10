package com.example.miras.newsapp.news

import android.annotation.SuppressLint
import com.example.miras.newsapp.core.BaseListener
import com.example.miras.newsapp.entity.News
import com.example.miras.newsapp.news.list.NewsListContract
import com.example.miras.newsapp.storage.RoomStorage


class NewsRepository(private val roomStorage: RoomStorage)
    : NewsListContract.Repository {


    @SuppressLint("CheckResult")
    override fun getNews(listener: BaseListener.onReadFinishedListener) {
        roomStorage.getNews().subscribe {
            listener.onReadFinished(it)
        }
    }

    override fun addNews(item : News) {
        roomStorage.insertNews(item)
    }

}