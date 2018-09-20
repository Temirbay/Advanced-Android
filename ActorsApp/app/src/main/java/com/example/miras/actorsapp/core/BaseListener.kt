package com.example.miras.actorsapp.core

import com.example.miras.actorsapp.actor.entities.Actor

interface BaseListener {

    interface onReadFinishedListener {
        fun onReadFinished(items : ArrayList<Actor>)
    }

    interface onAddFinishedListener  {
        fun onAddFinished(items : ArrayList<Actor>)
    }

}