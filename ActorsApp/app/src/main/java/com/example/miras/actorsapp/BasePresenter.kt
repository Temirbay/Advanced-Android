package com.example.miras.actorsapp


interface BasePresenter<V> {

    var view : V?

    fun start ()

    fun stop () {
        view = null
    }
}