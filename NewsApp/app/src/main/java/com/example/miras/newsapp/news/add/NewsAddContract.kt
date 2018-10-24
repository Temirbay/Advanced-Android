package com.example.miras.newsapp.news.add

import com.example.miras.newsapp.core.util.IPresenter
import com.example.miras.newsapp.core.util.IView


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