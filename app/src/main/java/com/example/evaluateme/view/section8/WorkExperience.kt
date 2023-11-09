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
import com.example.evaluateme.databinding.ActivityWorkExperienceBinding

class WorkExperience : AppCompatActivity() {
    lateinit var binding: ActivityWorkExperienceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkExperienceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val acaScore: Int = intent.getIntExtra("AcademicScore", 0)
        val nScore: Int = intent.getIntExtra("nScore", 0)
        val laScore: Int = intent.getIntExtra("laScore", 0)
        val businessScore: Int = intent.getIntExtra("businessScore", 0)
        val testScore: Int = intent.getIntExtra("testScore", 0)

        var score: Int = intent.getIntExtra("score", 0)

        var workExp = 0

        // btn onClick
        binding.btnWorkExpNext.setOnClickListener {

            val selectedRadioButtonId = binding.experienceRadioGroup.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val select = selectedRadioButton.text.toString()

                Toast.makeText(this, select, Toast.LENGTH_LONG).show()

                when (select) {
                    "0 - 2" -> {
                        score += 2
                        workExp += 2
                    }

                    "2 - 4" -> {
                        score += 4
                        workExp += 4
                    }

                    "5" -> {
                        score += 5
                        workExp += 5
                    }

                    "5 +" -> {
                        score += 5
                        workExp += 5
                    }
                }
            }



            val intent = Intent(this, CompanyType::class.java)
            intent.putExtra("score", score)
            intent.putExtra("nScore", nScore)
            intent.putExtra("AcademicScore", acaScore)
            intent.putExtra("laScore", laScore)
            intent.putExtra("businessScore", businessScore)
            intent.putExtra("testScore", testScore)
            intent.putExtra("workExp", workExp)
            startActivity(intent)
        }
    }
}