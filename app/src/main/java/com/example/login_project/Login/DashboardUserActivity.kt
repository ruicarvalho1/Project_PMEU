package com.example.login_project.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.login_project.R
import com.example.login_project.databinding.ActivityDashboardUserBinding
import com.google.firebase.auth.FirebaseAuth


class DashboardUserActivity : AppCompatActivity() {

    //View Binding
    private lateinit var binding : ActivityDashboardUserBinding

    //firebase auth
    private lateinit var firebaseAuth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardUserBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_dashboard_user)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        binding.logoutBtn.setOnClickListener{
            firebaseAuth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }

    }


    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser

        if(firebaseUser ==null){
            //not Logged in, user can stay in user dashboard without login too
           binding.subTitleTv.text = "Not Logged In"


        }else{
            //logged in, got and show user info
            val email = firebaseUser.email
            //set to textview of toolbar

            binding.subTitleTv.text=email

        }

    }



}