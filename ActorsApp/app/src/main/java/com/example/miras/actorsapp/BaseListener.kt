package com.example.miras.actorsapp

interface BaseListener {

    interface onReadFinishedListener {
        fun onReadFinished(items : ArrayList<Actor>)
    }

    interface onAddFinishedListener  {
        fun onAddFinished(items : ArrayList<Actor>)
    }

}