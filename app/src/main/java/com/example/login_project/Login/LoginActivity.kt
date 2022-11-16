package com.example.login_project.Login

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.login_project.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var progressDialog: ProgressDialog



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

       firebaseAuth = FirebaseAuth.getInstance()


        progressDialog=ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setCanceledOnTouchOutside(false)



        //handle click,begim Login
        binding.loginBtn.setOnClickListener{
        validateData()
        }
    }

    private var email= ""
    private var password =""

    private fun validateData(){

        email = binding.emailEt.text.toString().trim()
        password = binding.passwordEt.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher (email).matches ()) {
            Toast.makeText( this, "Invalid email format...",Toast.LENGTH_SHORT) .show()
        }

        else if (password.isEmpty()) {
            Toast.makeText( this, "Enter password...", Toast.LENGTH_SHORT) .show()
        }
        else {
            loginUser()
        }
    }

    private fun loginUser () {

        progressDialog.setMessage("Logging In...")
        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                //login success
                checkUser()
            }
            .addOnFailureListener { e->
                //failed login
                progressDialog.dismiss ()
                Toast.makeText (  this, "Login failed due to ${e.message}", Toast.LENGTH_SHORT) .show()
            }
    }

    private fun checkUser () {
        //Check user type - Firebase Auth
        //If User - Move to user dashboard
        //If Admin - Move to admin dashboard*/
        progressDialog.setMessage("Checking User...")

        val firebaseUser = firebaseAuth.currentUser!!

        val ref = FirebaseDatabase.getInstance().getReference("Users")

        ref.child(firebaseUser.uid)

            .addListenerForSingleValueEvent(object: ValueEventListener{

                override fun onDataChange (snapshot: DataSnapshot) {
                    progressDialog.dismiss ()


                    startActivity (Intent ( this@LoginActivity, DashboardUserActivity::class.java))
                    finish()

                    /*
                    else if (userType == "admin") {
                        //its admin, open admin dashboard
                        startActivity (Intent ( this@LoginActivity, DashboardAdminActivity::class.java))
                    }
                    */

                }

                override fun onCancelled(error:DatabaseError){


                }

            })

    }
}