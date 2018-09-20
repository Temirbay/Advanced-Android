package com.example.miras.actorsapp.actor

import org.koin.dsl.module.module

val actorApp = module {

    factory { ActorListPresenter(get()) as ActorListContract.Presenter}

    single { ActorRepositoryImpl() as ActorListContract.Repository}
}