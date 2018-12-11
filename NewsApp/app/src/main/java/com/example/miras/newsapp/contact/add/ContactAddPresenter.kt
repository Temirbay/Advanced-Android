package com.example.miras.newsapp.contact.add

import android.annotation.SuppressLint
import com.example.miras.newsapp.contact.list.ContactListContract
import com.example.miras.newsapp.core.util.BasePresenter
import com.example.miras.newsapp.entity.Contact


class ContactAddPresenter(private val repository: ContactListContract.Repository)
    : BasePresenter<ContactAddContract.View>(),
        ContactAddContract.Presenter{

    override fun viewIsReady() { }

    override fun destroy() {
        detachView()
    }

    @SuppressLint("CheckResult")
    override fun addContact(name: String, mobile_phone: String, home_phone: String, work_phone : String, url : String, group_id : Int) {
        if (validate (name, mobile_phone, home_phone, work_phone)) {
            val contact = Contact (0, name, mobile_phone, home_phone, work_phone, url, group_id)
            repository.addContact(contact)
            getView()?.onSuccess(contact)
        }
        else getView()?.onError()
    }

    private fun validate(name: String, mobile_phone: String, home_phone: String, work_phone : String): Boolean {
        if (name.isEmpty()) {
            getView()?.showMessage("Name is empty")
            return false
        }
        if (mobile_phone.isEmpty()) {
            getView()?.showMessage("Mobile Phone is empty")
            return false
        }
        if (home_phone.isEmpty()) {
            getView()?.showMessage("Home Phone is empty")
            return false
        }
        if (work_phone.isEmpty()) {
            getView()?.showMessage("Work Phone is empty")
            return false
        }

        return true
    }
}