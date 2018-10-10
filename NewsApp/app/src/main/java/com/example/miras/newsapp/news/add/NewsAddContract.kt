package com.example.miras.newsapp.news.add

import com.example.miras.newsapp.core.IPresenter
import com.example.miras.newsapp.core.IView


interface NewsAddContract {

    interface View : IView<Presenter> {
        fun showMessage (message : String)
        fun onSuccess ()
        fun onError ()
    }

    interface Presenter : IPresenter<View> {
        fun addNews (title : String, date : String, content : String, url : String)
    }
}