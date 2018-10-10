package com.example.miras.newsapp.storage

interface LocalStorage {

    fun saveEmail(email : String)

    fun getEmail() : String?
}