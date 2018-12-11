package com.example.miras.newsapp.storage

import com.example.miras.newsapp.entity.Contact
import com.example.miras.newsapp.entity.ContactGroup
import com.example.miras.newsapp.entity.ContactGroupDao
import io.reactivex.Observable


interface RoomStorage {
    fun getNews () : Observable<ArrayList<Contact>>
    fun insertNews (contact : Contact)
    fun getGroupById (id : Int) : Observable<ArrayList<ContactGroup>>
}