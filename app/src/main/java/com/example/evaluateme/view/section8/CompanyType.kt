package com.example.evaluateme.view.section8

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluateme.TotalScore
import com.example.evaluateme.databinding.ActivityCompanyTypeBinding

class CompanyType : AppCompatActivity() {
    lateinit var binding: ActivityCompanyTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompanyTypeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val acaScore: Int = intent.getIntExtra("AcademicScore", 0)
        val nScore: Int = intent.getIntExtra("nScore", 0)
        val laScore: Int = intent.getIntExtra("laScore", 0)
        val businessScore: Int = intent.getIntExtra("businessScore", 0)
        val testScore: Int = intent.getIntExtra("testScore", 0)
        val workExp: Int = intent.getIntExtra("workExp", 0)

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
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioBtnWork)
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

            val intent = Intent(this, TotalScore::class.java)
            intent.putExtra("score", score)
            intent.putExtra("nScore", nScore)
            intent.putExtra("AcademicScore", acaScore)
            intent.putExtra("laScore", laScore)
            intent.putExtra("businessScore", businessScore)
            intent.putExtra("testScore", testScore)
            intent.putExtra("workExp", workExp)
            intent.putExtra("companyType", companyType)
            startActivity(intent)
        }
    }
}