package com.example.miras.newsapp.news.list

import com.example.miras.newsapp.core.BaseListener
import com.example.miras.newsapp.core.BasePresenter
import com.example.miras.newsapp.entity.News
import com.example.miras.newsapp.news.list.NewsListContract


class NewsListPresenter(private val repository: NewsListContract.Repository)
    : BasePresenter<NewsListContract.View>(),
        NewsListContract.Presenter,
        BaseListener.onReadFinishedListener {

    override fun viewIsReady() { }

    override fun getNews() {
        repository.getNews(this)
    }

    override fun onReadFinished(items: ArrayList<News>) {
        getView()?.setAdapter(items)
    }

    override fun destroy() {
        detachView()
    }

}