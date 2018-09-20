package com.example.miras.actorsapp.actor

import com.example.miras.actorsapp.actor.entities.Actor
import com.example.miras.actorsapp.core.BaseListener
import com.example.miras.actorsapp.core.BasePresenter

class ActorListPresenter(private val repository: ActorListContract.Repository)
    : BasePresenter<ActorListContract.View>(),
        ActorListContract.Presenter,
        BaseListener.onAddFinishedListener,
        BaseListener.onReadFinishedListener{

    override fun viewIsReady() { }

    override fun destroy() {
        detachView()
    }

    override fun onReadFinished(items: ArrayList<Actor>) {
        getView()?.setAdapter(items)
    }

    override fun onAddFinished(items: ArrayList<Actor>) {
        getView()?.setAdapter(items)
        getView()?.showMessage ("Added")
    }


    override fun addActor(actor: Actor) {
        repository.addActor (actor, this)
    }

    override fun getActors() {
        repository.getActors (this)
    }

}