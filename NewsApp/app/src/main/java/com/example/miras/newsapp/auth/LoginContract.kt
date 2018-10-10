package com.example.miras.newsapp.auth

import com.example.miras.newsapp.core.BaseListener
import com.example.miras.newsapp.core.IPresenter
import com.example.miras.newsapp.core.IView


interface LoginContract {

    interface View : IView<Presenter> {
        fun onLoginSuccess ()
        fun onLoginError (message : String)
    }

    interface Presenter : IPresenter<View> {
        fun onLogin (email : String, password : String)
    }

    interface Repository {
        fun onLogin (listener : BaseListener.onLoginFinishedListener,
                     email : String, password : String)
    }

}