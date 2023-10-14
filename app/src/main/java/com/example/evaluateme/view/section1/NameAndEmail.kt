package com.example.evaluateme.view.section1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.evaluateme.R
import com.example.evaluateme.databinding.ActivityNameAndEmailBinding
import com.example.evaluateme.view.section2.QuesGender

class NameAndEmail : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var binding: ActivityNameAndEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameAndEmailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE)

        // set username and email
        binding.s1Email.setText(sharedPreferences.getString("email", ""))
        binding.s1Username.setText(sharedPreferences.getString("username", ""))

        binding.btnS1Next.setOnClickListener {
            startActivity(Intent(this, QuesGender::class.java))
            finish()
        }
    }
}