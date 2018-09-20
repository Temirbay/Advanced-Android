package com.example.miras.actorsapp.actor

import com.example.miras.actorsapp.actor.entities.Actor
import com.example.miras.actorsapp.core.BaseListener

class ActorRepositoryImpl : ActorListContract.Repository {

    private var items = ArrayList<Actor>()

    override fun getActors (listener : BaseListener.onReadFinishedListener) {
        listener.onReadFinished(items)
    }

    override fun addActor (actor : Actor, listener: BaseListener.onAddFinishedListener) {
        items.add(actor)
        listener.onAddFinished(items)
    }

}