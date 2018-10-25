package com.example.miras.newsapp.news.details

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.miras.newsapp.MainActivity
import com.example.miras.newsapp.R
import com.example.miras.newsapp.entity.News
import kotlinx.android.synthetic.main.activity_news_details.*

class NewsDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        setSupportActionBar(main_toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportActionBar?.setHomeButtonEnabled(true)

        val news = intent.getSerializableExtra("news") as News

        tvTitle.text = news.title
        tvDate.text = news.date
        tvContent.text = news.content

        if (news.imageUrl != "")
            Glide.with(this).load(news.imageUrl).into(main_backdrop)
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
