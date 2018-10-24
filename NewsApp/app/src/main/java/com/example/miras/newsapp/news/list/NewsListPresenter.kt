package com.example.miras.newsapp.news.list

import android.annotation.SuppressLint
import com.example.miras.newsapp.core.api.errorHandler.RetrofitException
import com.example.miras.newsapp.core.util.BaseListener
import com.example.miras.newsapp.core.util.BasePresenter
import com.example.miras.newsapp.core.util.Logger
import com.example.miras.newsapp.entity.News


class NewsListPresenter(private val repository: NewsListContract.Repository)
    : BasePresenter<NewsListContract.View>(),
        NewsListContract.Presenter {

    override fun viewIsReady() { }

    @SuppressLint("CheckResult")
    override fun getNews() {
        repository.getNews().subscribe ({
            getView()?.setAdapter(it as ArrayList<News>)
        }, { it as RetrofitException
            Logger.msg("getNews error: ${it.getErrorBody()?.message}")
        })
    }

    override fun destroy() {
        detachView()
    }

}