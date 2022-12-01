package com.example.login_project.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login_project.Login.Adapter.Horizontal_RecyclerView
import com.example.login_project.Login.Mapa.MainActivityM
import com.example.login_project.Login.PerfilUser.MainActivity_perfiluser
import com.example.login_project.Login.Retrofit.api.Endpoints
import com.example.login_project.Login.Retrofit.api.OutputLivro
import com.example.login_project.Login.Retrofit.api.ServiceBuilder
import com.example.login_project.R
import com.example.login_project.databinding.ActivityDashboardUserBinding
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DashboardUserActivity : AppCompatActivity() {

    //View Binding
    private lateinit var binding : ActivityDashboardUserBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Horizontal_RecyclerView


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
            startActivity(Intent(this, SplashActivity::class.java))
            finish()

        }

        val request = ServiceBuilder.buildService(Endpoints::class.java)
        val call = request.getLivros()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        call.enqueue(object : Callback<OutputLivro> {
            override fun onResponse(call: Call<OutputLivro>, response: Response<OutputLivro>) {
                if (response.isSuccessful){
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@DashboardUserActivity,LinearLayoutManager.HORIZONTAL,false)
                        val ou:OutputLivro  = response.body()!!
                        adapter = Horizontal_RecyclerView(ou.data)

                    }
                }
                Log.d("TAG", "sadasd")
            }
            override fun onFailure(call: Call<OutputLivro>, t: Throwable) {
                Toast.makeText(this@DashboardUserActivity, "${t.message}", Toast.LENGTH_SHORT).show() }
        })






       /*
       recyclerView2 = findViewById(R.id.recyclerView2)
        adapter = Horizontal_RecyclerView()

        recyclerView2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView2.adapter = adapter*/




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

