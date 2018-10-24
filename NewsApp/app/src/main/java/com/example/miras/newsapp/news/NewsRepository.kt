package com.example.miras.newsapp.news

import android.annotation.SuppressLint
import com.example.miras.newsapp.core.util.BaseListener
import com.example.miras.newsapp.entity.News
import com.example.miras.newsapp.news.list.NewsListContract
import com.example.miras.newsapp.storage.RoomStorage
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class NewsRepository(private val service: NewsService)
    : NewsListContract.Repository {


    override fun getNews() : Observable<List<News>> {
        return service.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun addNews(item : News) {
        service.addNews(item)
    }

}