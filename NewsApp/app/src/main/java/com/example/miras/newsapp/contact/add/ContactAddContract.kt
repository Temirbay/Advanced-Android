package com.example.miras.newsapp.contact.add

import com.example.miras.newsapp.core.util.IPresenter
import com.example.miras.newsapp.core.util.IView
import com.example.miras.newsapp.entity.Contact


interface ContactAddContract {

    interface View : IView<Presenter> {
        fun showMessage (message : String)
        fun onSuccess (contact : Contact)
        fun onError ()
    }

    interface Presenter : IPresenter<View> {
        fun addContact (name: String, mobile_phone: String, home_phone: String, work_phone : String, url : String, group_id : Int)
    }
}