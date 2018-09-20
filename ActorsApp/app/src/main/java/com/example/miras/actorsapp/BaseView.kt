package com.example.miras.actorsapp

interface BaseView <out P : BasePresenter<*>> {
    val presenter : P
}