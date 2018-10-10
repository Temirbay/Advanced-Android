package com.example.miras.newsapp.auth

import com.example.miras.newsapp.core.BaseListener
import com.example.miras.newsapp.core.BasePresenter


class LoginPresenter(private val repository: LoginContract.Repository)
    : BasePresenter<LoginContract.View>(),
        LoginContract.Presenter,
        BaseListener.onLoginFinishedListener{

    override fun viewIsReady() { }

    override fun destroy() {
        detachView()
    }

    override fun onLoginSuccess() {
        getView()?.onLoginSuccess()

    }

    override fun onLoginError(message : String) {
        getView()?.onLoginError(message)
    }

    override fun onLogin(email: String, password : String) {
        if (validate(email, password)) {
            repository.onLogin(this, email, password)
        }
    }

    private fun validate (email : String, password: String) : Boolean{
        if (email.isEmpty()) {
            getView()?.onLoginError("Email is empty")
            return false
        }
        if (password.isEmpty()) {
            getView()?.onLoginError("Password is empty")
            return false
        }
        return true
    }


}