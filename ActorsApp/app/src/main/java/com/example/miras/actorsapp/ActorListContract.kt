package com.example.miras.actorsapp

interface ActorListContract {

    interface View : BaseView<Presenter>{
        fun setAdapter (items : ArrayList<Actor>)
        fun showMessage (message : String)
    }

    interface Presenter : BasePresenter<View>{
        fun addActor(actor : Actor)
        fun getActors ()
    }

    interface Repository {
        fun getActors (listener : BaseListener.onReadFinishedListener)
        fun addActor (actor : Actor, listener: BaseListener.onAddFinishedListener)
    }

}