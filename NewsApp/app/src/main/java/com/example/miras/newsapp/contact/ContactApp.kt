package com.example.miras.newsapp.contact

import com.example.miras.newsapp.contact.list.ContactListContract
import com.example.miras.newsapp.contact.list.ContactListPresenter
import com.example.miras.newsapp.contact.add.ContactAddContract
import com.example.miras.newsapp.contact.add.ContactAddPresenter
import org.koin.dsl.module.module

val contactApp = module {

    factory { ContactListPresenter(get()) as ContactListContract.Presenter }
    factory { ContactAddPresenter(get()) as ContactAddContract.Presenter }

    factory { ContactRepository(get()) as ContactListContract.Repository }
}