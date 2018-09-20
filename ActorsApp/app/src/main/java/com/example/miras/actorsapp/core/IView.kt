package com.example.miras.actorsapp.core

interface IView <out P : IPresenter<*>> {
    val presenter : P
}