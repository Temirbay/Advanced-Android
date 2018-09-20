package com.example.miras.actorsapp

class ActorListPresenter(private val repository: ActorListContract.Repository,
                         override var view : ActorListContract.View?)
    : ActorListContract.Presenter,
        BaseListener.onAddFinishedListener,
        BaseListener.onReadFinishedListener{


    override fun start() {

    }

    override fun onReadFinished(items: ArrayList<Actor>) {
        view?.setAdapter(items)
    }

    override fun onAddFinished(items: ArrayList<Actor>) {
        view?.setAdapter(items)
        view?.showMessage ("Added")
    }


    override fun addActor(actor: Actor) {
        repository.addActor (actor, this)
    }

    override fun getActors() {
        repository.getActors (this)
    }

}