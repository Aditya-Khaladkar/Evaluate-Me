package com.example.evaluateme.view.section8

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.evaluateme.R
import com.example.evaluateme.TotalScore
import com.example.evaluateme.databinding.ActivityCompanyTypeBinding

class CompanyType : AppCompatActivity() {
    lateinit var binding: ActivityCompanyTypeBinding
    lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompanyTypeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = getSharedPreferences("ScorePref", Context.MODE_PRIVATE)

        var score: Int = intent.getIntExtra("score", 0)

        var companyType = 0

        binding.btnCompanyTypeNext.setOnClickListener {

            // for company type 1
            val selectedRadioButtonIdMNC = binding.companyTypeRadioGroup1.checkedRadioButtonId
            if (selectedRadioButtonIdMNC != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonIdMNC)
                val select = selectedRadioButton.text.toString()

                Toast.makeText(this, select, Toast.LENGTH_LONG).show()

                when (select) {
                    "MNC" -> {
                        score += 4
                        companyType += 4
                    }
                    "International MNC" -> {
                        score += 5
                        companyType += 5
                    }
                }
            }

           // for company 2
            val selectRadioButtonIdMNC2 = binding.companyTypeRadioGroup2.checkedRadioButtonId
            if (selectRadioButtonIdMNC2 != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectRadioButtonIdMNC2)
                val select = selectedRadioButton.text.toString()

                Toast.makeText(this, select, Toast.LENGTH_LONG).show()

                when (select) {
                    "Local company" -> {
                        score += 2
                        companyType += 2
                    }
                    "Startup" -> {
                        score += 4
                        companyType += 2
                    }
                }
            }

            // for work experience
            val selectedRadioBtnWork = binding.workplaceAchievementsRadioGroup.checkedRadioButtonId
            if (selectedRadioBtnWork != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectRadioButtonIdMNC2)
                val select = selectedRadioButton.text.toString()

                Toast.makeText(this, select, Toast.LENGTH_LONG).show()

                when (select) {
                    "Led a team of 10+" -> {
                        score += 3
                        companyType += 3
                    }
                    "Multiple promotions" -> {
                        score += 3
                        companyType += 3
                    }
                    "Created New processes/products/services / increased revenue by 15% or more" -> {
                        score += 5
                        companyType += 3
                    }
                    "Unique work profile" -> {
                        score += 5
                        companyType += 3
                    }
                }
            }

            val edit = sharedPref.edit()
            edit.putInt("companyType", companyType)

            val intent = Intent(this, TotalScore::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
        }
    }
}