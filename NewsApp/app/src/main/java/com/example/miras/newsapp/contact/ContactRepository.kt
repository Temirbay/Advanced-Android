package com.example.miras.newsapp.contact

import com.example.miras.newsapp.entity.Contact
import com.example.miras.newsapp.contact.list.ContactListContract
import com.example.miras.newsapp.storage.RoomStorage
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody


class ContactRepository(private val storage: RoomStorage)
    : ContactListContract.Repository {


    override fun getContacts() : Observable<ArrayList<Contact>> {
        return storage.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun addContact(item : Contact)  {
        storage.insertNews(item)
    }

}