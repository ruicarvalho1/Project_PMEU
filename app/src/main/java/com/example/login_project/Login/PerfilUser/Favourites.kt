package com.example.login_project.Login.PerfilUser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.login_project.Login.PerfilUser.dataclasses.Place
import com.example.login_project.R
import kotlinx.android.synthetic.main.activity_favourites.*

class Favourites : AppCompatActivity() {

    private lateinit var myList: ArrayList<Place>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourites)

        getSupportActionBar()?.hide()

        myList = ArrayList<Place>()

        for (i in 0 until 10){
            myList.add(Place("Titulo $i", "Biblioteca $i", "Disponível $i"))
        }
        recycler_view.adapter = LineAdapter(myList)
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    fun info(view: View){
        val intent = Intent(this, MainActivity_perfiluser::class.java).apply {}
        startActivity(intent)
    }

}