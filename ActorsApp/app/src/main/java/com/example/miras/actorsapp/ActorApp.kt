package com.example.miras.actorsapp

import org.koin.dsl.module.module

val actorApp = module {

    factory { (view : ActorListContract.View) -> ActorListPresenter(get(), view)
            as ActorListContract.Presenter}

    single {ActorRepositoryImpl() as ActorListContract.Repository}
}