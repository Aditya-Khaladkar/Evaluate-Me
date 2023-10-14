package com.example.evaluateme.auth

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.evaluateme.R
import com.example.evaluateme.databinding.ActivitySignUpBinding
import com.example.evaluateme.view.section1.NameAndEmail

class SignUp : AppCompatActivity() {
    lateinit var sharedPref: SharedPreferences
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE)

        binding.btnSignUp.setOnClickListener {
            val username: String = binding.regUsername.text.toString()
            val email: String = binding.regEmail.text.toString()
            val password: String = binding.regPassword.text.toString()

            val editor = sharedPref.edit()
            editor.putString("username", username)
            editor.putString("email", email)
            editor.putString("password", password)
            editor.apply()

            Toast.makeText(this, "Registration Successful", Toast.LENGTH_LONG).show()
            val intent = Intent(this, NameAndEmail::class.java)
            startActivity(intent)
            finish()
        }
    }
}