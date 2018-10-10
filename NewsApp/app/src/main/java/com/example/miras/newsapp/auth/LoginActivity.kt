package com.example.miras.newsapp.auth

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.miras.newsapp.MainActivity
import com.example.miras.newsapp.R
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity(), LoginContract.View {

    override val presenter: LoginContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button.setOnClickListener {
            login(emailValue.text.toString(),
                    passwordValue.text.toString())
        }

        presenter.attachView(this)
    }

    private fun login (email : String, password : String) {
        presenter.onLogin (email, password)
    }

    override fun onLoginSuccess() {
        val intent = Intent (this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}