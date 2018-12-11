package com.example.miras.newsapp

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import com.example.miras.newsapp.entity.Contact
import com.example.miras.newsapp.contact.ContactAdapter
import com.example.miras.newsapp.contact.ContactItemClicked
import com.example.miras.newsapp.contact.add.ContactAddActivity
import com.example.miras.newsapp.contact.details.ContactDetailsActivity
import com.example.miras.newsapp.contact.list.ContactListContract
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class MainActivity : AppCompatActivity(),
        ContactListContract.View,
        ContactItemClicked, SearchView.OnQueryTextListener {

    override fun onQueryTextSubmit(query: String?): Boolean {
        presenter.search (query)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        presenter.search (newText)
        return false
    }

    private val code = 1

    private lateinit var list : ArrayList<Contact>
    private lateinit var adapter : ContactAdapter

    override val presenter: ContactListContract.Presenter
            by inject { parametersOf(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fab.setOnClickListener {
            val intent = Intent (this, ContactAddActivity::class.java)
            startActivityForResult(intent, code)
        }

        search.setOnQueryTextListener(this)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            recyclerView.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager?
        else
            recyclerView.layoutManager = LinearLayoutManager(this)


        list = ArrayList()
        adapter = ContactAdapter(this, list, this, this)
        recyclerView.adapter = adapter

        presenter.getContacts()
        presenter.attachView(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == code) {
            if (resultCode == Activity.RESULT_OK) {
                presenter.getContacts()
                showMessage("Added")
            }
        }
    }

    override fun setItems(items: ArrayList<Contact>) {
        adapter = ContactAdapter(this, items, this, this)
        recyclerView.adapter = adapter
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClicked(contact: Contact) {
        val intent = Intent (this, ContactDetailsActivity::class.java)
        intent.putExtra("contact", contact)
        startActivity(intent)
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

}
