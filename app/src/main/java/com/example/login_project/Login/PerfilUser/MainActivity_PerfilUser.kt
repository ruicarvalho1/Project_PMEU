package com.example.login_project.Login.PerfilUser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.login_project.R

class MainActivity_perfiluser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_perfiluser)

        getSupportActionBar()?.hide()
    }

    fun favourites(view: View){
        val intent = Intent(this, Favourites::class.java).apply {}
        startActivity(intent)
    }

    fun settings(view: View){
        val intent = Intent(this, Settings::class.java).apply {}
        startActivity(intent)
    }

    fun logout(view: View){
        val intent = Intent(this, Settings::class.java).apply {}
        startActivity(intent)
    }

}