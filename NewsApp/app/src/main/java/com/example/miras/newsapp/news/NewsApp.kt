package com.example.miras.newsapp.news

import com.example.miras.newsapp.news.list.NewsListContract
import com.example.miras.newsapp.news.list.NewsListPresenter
import com.example.miras.newsapp.news.add.NewsAddContract
import com.example.miras.newsapp.news.add.NewsAddPresenter
import org.koin.dsl.module.module

val newsApp = module {

    factory { NewsListPresenter(get()) as NewsListContract.Presenter }
    factory { NewsAddPresenter(get()) as NewsAddContract.Presenter }


    single { NewsRepository(get()) as NewsListContract.Repository }
}