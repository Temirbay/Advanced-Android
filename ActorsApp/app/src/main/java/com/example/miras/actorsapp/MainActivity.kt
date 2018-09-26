package com.example.miras.actorsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.miras.actorsapp.actor.entities.Actor
import com.example.miras.actorsapp.actor.ActorAdapter
import com.example.miras.actorsapp.actor.ActorListContract
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), ActorListContract.View {


    override val presenter: ActorListContract.Presenter
            by inject {parametersOf(this)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bnAdd.setOnClickListener{ addActor()}

        recyclerView.layoutManager = LinearLayoutManager(this)

        presenter.attachView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.getActors()
    }

    private fun addActor() {
        presenter.addActor(Actor("Johny", "Depp",
                "Pirates of the Caribbean"))
    }

    override fun setAdapter(items: ArrayList<Actor>) {
        val adapter = ActorAdapter(this, items)
        recyclerView.adapter = adapter
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

}
