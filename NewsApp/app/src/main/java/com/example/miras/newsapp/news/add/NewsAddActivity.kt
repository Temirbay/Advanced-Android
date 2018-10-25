package com.example.miras.newsapp.news.add

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.miras.newsapp.R
import com.example.miras.newsapp.entity.News
import kotlinx.android.synthetic.main.activity_news_add.*
import org.koin.android.ext.android.inject

class NewsAddActivity : AppCompatActivity(), NewsAddContract.View {


    override val presenter: NewsAddContract.Presenter by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_add)

        addButton.setOnClickListener {
            addNews (titleValue.text.toString(),
                    dateValue.text.toString(),
                    contentValue.text.toString())
        }

        presenter.attachView(this)
    }

    private fun addNews(title: String, date: String, content: String) {
        presenter.addNews(title, date, content, "")
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(news : News) {
        val returnIntent = Intent()
        returnIntent.putExtra("news", news)
        setResult(Activity.RESULT_OK, returnIntent)
        finish()
    }

    override fun onError() {
        val returnIntent = Intent()
        setResult(Activity.RESULT_CANCELED, returnIntent)
        finish()
    }
}
