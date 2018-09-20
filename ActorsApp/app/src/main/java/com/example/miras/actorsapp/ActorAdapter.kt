package com.example.miras.actorsapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import kotlinx.android.synthetic.main.item_actor.view.*

class ActorAdapter(private val context : Context,
                   private val items : ArrayList<Actor>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : RecyclerView.ViewHolder {
        return ActorsViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_actor, parent, false))
    }

    override fun getItemCount(): Int {
      return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val actor = items[position]
        holder.itemView.tvName.text = actor.name
        holder.itemView.tvSurname.text = actor.surname
        holder.itemView.tvFilm.text = actor.film
    }

   class ActorsViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView)
}