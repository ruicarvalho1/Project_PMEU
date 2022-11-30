package com.example.login_project.Login.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.login_project.Login.Retrofit.api.Livro
import com.example.login_project.Login.Retrofit.api.User
import com.example.login_project.R
import java.lang.Boolean


class Horizontal_RecyclerView (val livros: List<Livro>): RecyclerView.Adapter<Horizontal_RecyclerView.UsersViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        return holder.bind(livros[position])
    }

    override fun getItemCount(): Int {

            return livros.size


    }

    class UsersViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val titulo: TextView = itemView.findViewById(R.id.titleTV)
        private val autor: TextView = itemView.findViewById(R.id.autortv)
        private val categoria: TextView = itemView.findViewById(R.id.categoriatv)
        private val isbn: TextView = itemView.findViewById(R.id.isbntv)
        private val disponibilidade: TextView = itemView.findViewById(R.id.disponibilidadetv)






        fun bind(livro: Livro){
            autor.text = livro.autores
            categoria.text = livro.categoria
            titulo.text = livro.titulo
            isbn.text = livro.isbn.toString()
            disponibilidade.text = livro.disponibilidade.toString()
        }
    }

}