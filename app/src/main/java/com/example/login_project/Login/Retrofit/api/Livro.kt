package com.example.login_project.Login.Retrofit.api

data class Livro (

    val idLivro: Int,
    val isbn: Int,
    val titulo: String,
    val autores: String,
    val editora: String,
    val sinopse: String,
    val categoria: String,
    val opinioes: String,
    val disponibilidade: Boolean,
    val imageUrl: String,

    )