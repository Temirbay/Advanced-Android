package com.example.miras.newsapp.auth

import com.example.miras.newsapp.storage.LocalStorage
import com.example.miras.newsapp.core.BaseListener


class LoginRepository(private val localStorage : LocalStorage)
    : LoginContract.Repository {

    override fun onLogin(listener : BaseListener.onLoginFinishedListener,
                         email: String, password: String) {
        localStorage.saveEmail(email)
        listener.onLoginSuccess()
    }

}