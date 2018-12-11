package com.example.miras.newsapp.contact

import android.annotation.SuppressLint
import android.arch.persistence.room.Room
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.miras.newsapp.R
import com.example.miras.newsapp.entity.Contact
import kotlinx.android.synthetic.main.item_contact.view.*
import android.graphics.drawable.Drawable
import com.example.miras.newsapp.contact.add.ContactAddContract
import com.example.miras.newsapp.entity.ContactDatabase
import com.example.miras.newsapp.storage.RoomStorage
import com.example.miras.newsapp.storage.RoomStorageImpl
import org.koin.android.ext.android.inject
import java.io.InputStream
import java.net.URL
import com.example.miras.newsapp.MainActivity
import com.example.miras.newsapp.core.util.Logger


class ContactAdapter(private val context : Context,
                     private val items : ArrayList<Contact>,
                     private val listener : ContactItemClicked,
                     private val activity: MainActivity)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return ContactViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_contact, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val contact = items[p1]
        p0.itemView.tvName.text = contact.name

        val database = Room.databaseBuilder(context, ContactDatabase::class.java, "contactDB")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()

        Logger.msg(contact.contact_group_id)

        database.contactGroupsDao().getGroupById(contact.contact_group_id).subscribe {
            if (!it.isEmpty()) {
                val group = it.first()
                activity.runOnUiThread {
                    p0.itemView.tvGroup.text = group.name
                }
            }

        }
//        if (contact.photo != "") {
//            p0.itemView.iv.setImageDrawable(grabImageFromUrl(contact.photo))
//        }

        p0.itemView.setOnClickListener {
            listener.onItemClicked(contact)
        }
    }

    @Throws(Exception::class)
    private fun grabImageFromUrl(url: String): Drawable {
        return Drawable.createFromStream(URL(url).content as InputStream, "src")
    }

    class ContactViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView)

}

interface ContactItemClicked {
    fun onItemClicked (contact : Contact)
}