package com.example.login_project.Login.Retrofit.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoints {

    @GET("/api/user/")
    fun getUsers(): Call<OutputUser>

    @GET("api/livro/")
    fun getLivros(): Call<OutputLivro>

    @GET("api/livro/{id}")
    fun getLivrosByid(@Path("id") id: Int): Call<Livro>

    @GET("api/user/{id}")
    fun getUserByid(@Path("id") id: Int): Call<OutputUserId>



}