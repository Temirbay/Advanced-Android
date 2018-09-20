package com.example.miras.actorsapp.core

interface IPresenter<V> {

    fun attachView(view: V)

    fun viewIsReady()

    fun detachView()

    fun destroy()

}