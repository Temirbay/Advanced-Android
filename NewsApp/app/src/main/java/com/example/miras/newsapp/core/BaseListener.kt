package com.example.miras.newsapp.core

import com.example.miras.newsapp.entity.News


interface BaseListener {

    interface onReadFinishedListener {
        fun onReadFinished(items : ArrayList<News>)
    }


    interface onLoginFinishedListener {
        fun onLoginSuccess()
        fun onLoginError(message : String)
    }
}