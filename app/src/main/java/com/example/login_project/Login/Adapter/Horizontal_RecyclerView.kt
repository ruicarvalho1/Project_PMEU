package com.example.login_project.Login.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.GenericTransitionOptions.with
import com.bumptech.glide.Glide.with
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.with
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.with
import com.example.login_project.Login.Retrofit.api.Livro
import com.example.login_project.Login.Retrofit.api.User
import com.example.login_project.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_settings.view.*
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
        private val imageUrl: ImageView = itemView.findViewById(R.id.ImageIv)
        private val titulo: TextView = itemView.findViewById(R.id.titleTV)
        private val autor: TextView = itemView.findViewById(R.id.autortv)
        private val categoria: TextView = itemView.findViewById(R.id.categoriatv)
        private val isbn: TextView = itemView.findViewById(R.id.isbntv)
        private val editora: TextView = itemView.findViewById(R.id.editoratv)
        private val sinopse: TextView = itemView.findViewById(R.id.sinopsetv)
        private val opinioes: TextView = itemView.findViewById(R.id.opinioestv)
        private val disponibilidade: TextView = itemView.findViewById(R.id.disponibilidadetv)






        fun bind(livro: Livro){
            var picasso = Picasso.get()
            picasso.load(livro.imageUrl).fit().centerCrop().into(imageUrl)
            autor.text = livro.autores
            categoria.text = livro.categoria
            titulo.text = livro.titulo
            editora.text = livro.editora
            sinopse.text = livro.sinopse
            opinioes.text = livro.opinioes
            isbn.text = livro.isbn.toString()
            disponibilidade.text = livro.disponibilidade.toString()
        }
    }

}