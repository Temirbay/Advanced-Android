package com.example.miras.newsapp.news.list

import com.example.miras.newsapp.core.util.BaseListener
import com.example.miras.newsapp.core.util.IPresenter
import com.example.miras.newsapp.core.util.IView
import com.example.miras.newsapp.entity.News
import io.reactivex.Observable


interface NewsListContract {

    interface View : IView<Presenter> {
        fun setAdapter (items : ArrayList<News>)
        fun showMessage (message : String)
    }

    interface Presenter : IPresenter<View> {
        fun getNews ()
    }

    interface Repository {
        fun getNews () : Observable<List<News>>
        fun addNews (item : News)
    }

}