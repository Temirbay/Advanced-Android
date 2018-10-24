package com.example.miras.newsapp

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.miras.newsapp.entity.News
import com.example.miras.newsapp.news.NewsAdapter
import com.example.miras.newsapp.news.NewsItemClicked
import com.example.miras.newsapp.news.add.NewsAddActivity
import com.example.miras.newsapp.news.details.NewsDetailsActivity
import com.example.miras.newsapp.news.list.NewsListContract
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class MainActivity : AppCompatActivity(),
        NewsListContract.View,
        NewsItemClicked,
        NavigationView.OnNavigationItemSelectedListener {


    private val code = 1

    override val presenter: NewsListContract.Presenter
            by inject { parametersOf(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        fab.setOnClickListener {
            val intent = Intent (this, NewsAddActivity::class.java)
            startActivityForResult(intent, code)
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            recyclerView.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager?
        else
            recyclerView.layoutManager = LinearLayoutManager(this)


        presenter.attachView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.getNews()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == code) {
            if (resultCode == Activity.RESULT_OK) {
                presenter.getNews()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


    override fun setAdapter(items: ArrayList<News>) {
        runOnUiThread {
            val adapter = NewsAdapter(this, items, this)
            recyclerView.adapter = adapter
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClicked(news: News) {
        val intent = Intent (this, NewsDetailsActivity::class.java)
        intent.putExtra("title", news.title)
        intent.putExtra("date", news.date)
        intent.putExtra("content", news.content)
        intent.putExtra("url", news.imageUrl)
        startActivity(intent)
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

}
