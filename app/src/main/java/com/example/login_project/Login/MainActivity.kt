package com.example.login_project.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login_project.R
import com.example.login_project.databinding.ActivityMainBinding
import com.example.login_project.Login.Adapter.Horizontal_RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //handle click
        binding.loginBtn.setOnClickListener{

            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.skipBtn.setOnClickListener{
            startActivity(Intent(this, DashboardUserActivity::class.java))
        }



        }

    }


