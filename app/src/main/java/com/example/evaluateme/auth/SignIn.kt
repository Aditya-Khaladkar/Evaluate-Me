package com.example.evaluateme.auth

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.evaluateme.R
import com.example.evaluateme.databinding.ActivitySignInBinding

class SignIn : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE)

        binding.btnSignIn.setOnClickListener {
            val email: String = binding.logEmail.text.toString()
            val password: String = binding.logPassword.text.toString()
        }
    }
}