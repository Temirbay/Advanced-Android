package com.example.miras.newsapp.news.add

import android.annotation.SuppressLint
import com.example.miras.newsapp.core.api.errorHandler.RetrofitException
import com.example.miras.newsapp.news.list.NewsListContract
import com.example.miras.newsapp.core.util.BasePresenter
import com.example.miras.newsapp.core.util.Logger
import com.example.miras.newsapp.entity.News


class NewsAddPresenter(private val repository: NewsListContract.Repository)
    : BasePresenter<NewsAddContract.View>(),
        NewsAddContract.Presenter{

    override fun viewIsReady() { }

    override fun destroy() {
        detachView()
    }

    @SuppressLint("CheckResult")
    override fun addNews(title: String, date: String, content: String, url : String) {
        if (validate (title, date, content)) {
            val news = News (0, title, date, content, url)
            repository.addNews(news).subscribe ({
                getView()?.onSuccess(news)
            }, { it as RetrofitException
                Logger.msg("getNews error: ${it.getErrorBody()?.message}")
            })
        }
        else getView()?.onError()
    }

    private fun validate(title: String, date: String, content: String): Boolean {
        if (title.isEmpty()) {
            getView()?.showMessage("Title is empty")
            return false
        }
        if (date.isEmpty()) {
            getView()?.showMessage("Date is empty")
            return false
        }
        if (content.isEmpty()) {
            getView()?.showMessage("Content is empty")
            return false
        }
        return true
    }
}