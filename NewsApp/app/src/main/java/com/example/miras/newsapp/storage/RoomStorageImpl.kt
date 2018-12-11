package com.example.miras.newsapp.storage

import com.example.miras.newsapp.entity.Contact
import com.example.miras.newsapp.entity.ContactDao
import com.example.miras.newsapp.entity.ContactDatabase
import com.example.miras.newsapp.entity.ContactGroup
import io.reactivex.Observable


class RoomStorageImpl(private val database : ContactDatabase) : RoomStorage {

    override fun getGroupById(id: Int): Observable<ArrayList<ContactGroup>> {
        return database.contactGroupsDao().getGroupById(id)
                .map { it as ArrayList<ContactGroup> }
                .toObservable()
    }

    override fun getNews(): Observable<ArrayList<Contact>> {
        return database.contactDao().getContacts()
                .map { it as ArrayList<Contact> }
                .toObservable()
    }

    override fun insertNews(contact: Contact) {
        database.contactDao().insertContact(contact)
    }



}