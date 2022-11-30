package com.example.login_project.Login.PerfilUser

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.login_project.Login.PerfilUser.dataclasses.Place
import com.example.login_project.R
import kotlinx.android.synthetic.main.recyclerline.view.*

class LineAdapter(val list: ArrayList<Place>): RecyclerView.Adapter<LineViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LineViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recyclerline, parent, false);
        return LineViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LineViewHolder, position: Int){
        val currentPlace = list[position]

        holder.title.text = currentPlace.title
        holder.library.text = currentPlace.library
        holder.available.text = currentPlace.available
    }
}

class LineViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    val title = itemView.title
    val library = itemView.library
    val available = itemView.available
}