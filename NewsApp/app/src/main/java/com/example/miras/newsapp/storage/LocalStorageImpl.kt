package com.example.miras.newsapp.storage

import android.content.SharedPreferences
import com.example.miras.newsapp.storage.LocalStorage

class LocalStorageImpl(private val pref : SharedPreferences)
    : LocalStorage {


    override fun saveEmail(email: String) {
        pref.edit()
                .putString("USER_EMAIL", email)
                .apply()
    }

    override fun getEmail(): String? =
            pref.getString("USER_EMAIL", null)


}