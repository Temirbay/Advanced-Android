package com.example.miras.newsapp.contact.details

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.miras.newsapp.MainActivity
import com.example.miras.newsapp.R
import com.example.miras.newsapp.entity.Contact
import kotlinx.android.synthetic.main.activity_contact_details.*

class ContactDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        val contact = intent.getSerializableExtra("contact") as Contact

        tvName.text = contact.name
        tvMobile.text = contact.mobile_phone
        tvHome.text = contact.home_phone
        tvWork.text = contact.work_phone

        if (contact.photo != "")
            Glide.with(this).load(contact.photo).into(ivProfile)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                val intent = Intent (this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }

}
