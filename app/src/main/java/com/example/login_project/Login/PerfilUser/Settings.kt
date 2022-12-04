package com.example.login_project.Login.PerfilUser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.login_project.Login.DashboardUserActivity
import com.example.login_project.Login.Mapa.MainActivityM
import com.example.login_project.R

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        getSupportActionBar()?.hide()
    }

    fun Funcionlide_1(view: View) {
        val intent = Intent(this, DashboardUserActivity::class.java).apply {

        }
        startActivity(intent)
    }

    fun Funcionlide_3(view: View) {
        val intent = Intent(this, MainActivityM::class.java).apply {

        }
        startActivity(intent)
    }
    fun Funcionlide_4(view: View) {
        val intent = Intent(this, MainActivity_perfiluser::class.java).apply {

        }
        startActivity(intent)
    }
}