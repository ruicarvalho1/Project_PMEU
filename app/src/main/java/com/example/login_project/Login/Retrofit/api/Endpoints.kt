package com.example.login_project.Login.Retrofit.api

import retrofit2.Call
import retrofit2.http.GET

interface Endpoints {

    @GET("/api/user/")
    fun getUsers(): Call<OutputUser>

    @GET("api/livro/")
    fun getLivros(): Call<OutputLivro>
}