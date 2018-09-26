package com.example.miras.actorsapp.core

import com.example.miras.actorsapp.actor.entities.Actor

interface BaseListener {



    interface onAddFinishedListener  {
        fun onAddFinished(items : ArrayList<Actor>)
    }

}