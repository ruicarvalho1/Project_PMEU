package com.example.login_project.Login.PerfilUser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide.with
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.with
import com.example.login_project.Login.DashboardUserActivity
import com.example.login_project.Login.Mapa.MainActivityM
import com.example.login_project.Login.Retrofit.api.*
import com.example.login_project.Login.SplashActivity
import com.example.login_project.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_settings.*
import okhttp3.HttpUrl.get
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity_perfiluser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_perfiluser)

        getSupportActionBar()?.hide()

        val request = ServiceBuilder.buildService(Endpoints::class.java)
        val call = request.getUserByid(1)

        call.enqueue(object : Callback<OutputUserId> {
            override fun onResponse(call: Call<OutputUserId>, response: Response<OutputUserId>) {
                if (response.isSuccessful) {
                    val c: OutputUserId = response.body()!!

                    var imageUrl: ImageView = findViewById(R.id.imagemUser)
                    var picasso = Picasso.get()
                    picasso.load(c.data.imageUserUrl).into(imageUrl)

                    val nome: TextView = findViewById(R.id.textNomeUsuario) as TextView
                    nome.setText(c.data.nome)

                    val email: TextView = findViewById(R.id.textEmailUsuario) as TextView
                    email.setText(c.data.email)

                    val numero: TextView = findViewById(R.id.textNumberUsuario) as TextView
                    numero.setText(c.data.numeroAluno.toString())

                    val curso: TextView = findViewById(R.id.textCurso) as TextView
                    curso.setText(c.data.curso)

                    Log.d("TAG", "IF")
                }
                Log.d("TAG", "Sucesso")
            }

            override fun onFailure(call: Call<OutputUserId>, t: Throwable) {
                Toast.makeText(this@MainActivity_perfiluser, "${t.message}", Toast.LENGTH_SHORT).show()
                Log.d("TAG", "FALHOU")
            }
        })

    }

    fun settings(view: View){
        val intent = Intent(this, Settings::class.java).apply {}
        startActivity(intent)
    }

    fun logout(view: View){
        val intent = Intent(this, SplashActivity::class.java).apply {}
        startActivity(intent)
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