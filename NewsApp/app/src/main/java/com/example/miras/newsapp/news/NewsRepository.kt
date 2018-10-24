package com.example.miras.newsapp.news

import com.example.miras.newsapp.entity.News
import com.example.miras.newsapp.news.list.NewsListContract
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody


class NewsRepository(private val service: NewsService)
    : NewsListContract.Repository {


    override fun getNews() : Observable<List<News>> {
        return service.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun addNews(item : News): Observable<ResponseBody> {
        return service.addNews(item)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}