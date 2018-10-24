package com.example.miras.newsapp.core.util


interface IView <out P : IPresenter<*>> {
    val presenter : P
}