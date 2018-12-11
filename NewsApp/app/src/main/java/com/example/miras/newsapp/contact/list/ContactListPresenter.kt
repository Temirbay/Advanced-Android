package com.example.miras.newsapp.contact.list

import android.annotation.SuppressLint
import com.example.miras.newsapp.core.util.BasePresenter
import com.example.miras.newsapp.entity.Contact


class ContactListPresenter(private val repository: ContactListContract.Repository)
    : BasePresenter<ContactListContract.View>(),
        ContactListContract.Presenter {

    @SuppressLint("CheckResult")
    override fun search(query: String?) {
        getView()?.showProgress()
        repository.getContacts().subscribe {
            val list = ArrayList<Contact>()
            it.forEach { item ->
                if (item.name.contains(query!!, true)) {
                    list.add(item)
                }
                if (item.home_phone.contains(query, true)) {
                    if (!list.contains(item))
                        list.add(item)
                }
                if (item.mobile_phone.contains(query, true)) {
                    if (!list.contains(item))
                        list.add(item)
                }
                if (item.work_phone.contains(query, true)) {
                    if (!list.contains(item))
                        list.add(item)
                }
            }
            getView()?.setItems(list)
            getView()?.hideProgress()
        }
    }

    override fun viewIsReady() { }

    @SuppressLint("CheckResult")
    override fun getContacts() {
        getView()?.showProgress()
        repository.getContacts().subscribe {
            getView()?.setItems(it as ArrayList<Contact>)
            getView()?.hideProgress()
        }
    }

    override fun destroy() {
        detachView()
    }

}