package com.example.miras.newsapp.contact.list

import com.example.miras.newsapp.core.util.IPresenter
import com.example.miras.newsapp.core.util.IView
import com.example.miras.newsapp.entity.Contact
import io.reactivex.Observable
import okhttp3.ResponseBody


interface ContactListContract {

    interface View : IView<Presenter> {
        fun setItems (items : ArrayList<Contact>)
        fun showMessage (message : String)
        fun showProgress ()
        fun hideProgress ()
    }

    interface Presenter : IPresenter<View> {
        fun getContacts ()
        fun search(query: String?)
    }

    interface Repository {
        fun getContacts () : Observable<ArrayList<Contact>>
        fun addContact (item : Contact)
    }

}