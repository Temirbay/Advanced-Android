package com.example.miras.newsapp.auth

import org.koin.dsl.module.module


val loginApp = module {

    factory { LoginPresenter(get()) as LoginContract.Presenter }

    single { LoginRepository(get()) as LoginContract.Repository }


}