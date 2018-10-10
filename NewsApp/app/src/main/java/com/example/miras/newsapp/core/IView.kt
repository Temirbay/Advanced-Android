package com.example.miras.newsapp.core



interface IView <out P : IPresenter<*>> {
    val presenter : P
}