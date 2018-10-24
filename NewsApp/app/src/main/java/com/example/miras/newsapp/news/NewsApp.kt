package com.example.miras.newsapp.news

import com.example.miras.newsapp.core.api.Constants
import com.example.miras.newsapp.core.createService
import com.example.miras.newsapp.news.list.NewsListContract
import com.example.miras.newsapp.news.list.NewsListPresenter
import com.example.miras.newsapp.news.add.NewsAddContract
import com.example.miras.newsapp.news.add.NewsAddPresenter
import org.koin.dsl.module.module

val newsApp = module {

    factory { NewsListPresenter(get()) as NewsListContract.Presenter }
    factory { NewsAddPresenter(get()) as NewsAddContract.Presenter }


    factory { NewsRepository(get()) as NewsListContract.Repository }

    single { createService<NewsService>(get(), Constants.url) }
}