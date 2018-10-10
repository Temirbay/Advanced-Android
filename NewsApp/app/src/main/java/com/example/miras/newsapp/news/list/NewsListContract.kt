package com.example.miras.newsapp.news.list

import com.example.miras.newsapp.core.BaseListener
import com.example.miras.newsapp.core.IPresenter
import com.example.miras.newsapp.core.IView
import com.example.miras.newsapp.entity.News


interface NewsListContract {

    interface View : IView<Presenter> {
        fun setAdapter (items : ArrayList<News>)
        fun showMessage (message : String)
    }

    interface Presenter : IPresenter<View> {
        fun getNews ()
    }

    interface Repository {
        fun getNews (listener : BaseListener.onReadFinishedListener)
        fun addNews (item : News)
    }

}