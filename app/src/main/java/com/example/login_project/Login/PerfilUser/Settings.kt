package com.example.login_project.Login.PerfilUser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login_project.R

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        getSupportActionBar()?.hide()
    }
}