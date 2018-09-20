package com.example.miras.actorsapp.actor

import com.example.miras.actorsapp.actor.entities.Actor
import com.example.miras.actorsapp.core.BaseListener
import com.example.miras.actorsapp.core.IPresenter
import com.example.miras.actorsapp.core.IView

interface ActorListContract {

    interface View : IView<Presenter> {
        fun setAdapter (items : ArrayList<Actor>)
        fun showMessage (message : String)
    }

    interface Presenter : IPresenter<View> {
        fun addActor(actor : Actor)
        fun getActors ()
    }

    interface Repository {
        fun getActors (listener : BaseListener.onReadFinishedListener)
        fun addActor (actor : Actor, listener: BaseListener.onAddFinishedListener)
    }

}