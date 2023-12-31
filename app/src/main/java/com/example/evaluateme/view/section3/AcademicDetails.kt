package com.example.evaluateme.view.section3

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluateme.databinding.ActivityAcademicDetailsBinding
import com.example.evaluateme.view.section4.NotableAchievements

class AcademicDetails : AppCompatActivity() {
    lateinit var binding: ActivityAcademicDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAcademicDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var score: Int = intent.getIntExtra("score", 0)

        var acaScore = 0

        binding.btnAcaNext.setOnClickListener {

            // for 10th score
            val selectedRadioButtonId10 = binding.class10ScoreRadioGroup.checkedRadioButtonId
            if (selectedRadioButtonId10 != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId10)
                val select = selectedRadioButton.text.toString()

                Toast.makeText(this, select, Toast.LENGTH_LONG).show()

                when (select) {
                    "90 +" -> {
                        score += 4
                        acaScore += 4
                    }
                    "80 +" -> {
                        score += 3
                        acaScore += 3
                    }
                    "75 +" -> {
                        score += 2
                        acaScore += 2
                    }
                    "75 and below" -> {
                        score += 1
                        acaScore += 1
                    }
                }
            }

            // for 12th score
            val selectedRadioButtonId12 = binding.class12ScoreRadioGroup.checkedRadioButtonId
            if (selectedRadioButtonId12 != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId12)
                val select = selectedRadioButton.text.toString()

                Toast.makeText(this, select, Toast.LENGTH_LONG).show()

                when (select) {
                    "85 +" -> {
                        score += 4
                        acaScore += 4
                    }
                    "75 +" -> {
                        score += 3
                        acaScore += 3
                    }
                    "Below 75" -> {
                        score += 2
                        acaScore += 2
                    }
                }
            }

            // college GPA
            val selectedRadioButtonIdGPA = binding.classGPAScoreRadioGroup.checkedRadioButtonId
            if (selectedRadioButtonIdGPA != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonIdGPA)
                val select = selectedRadioButton.text.toString()

                Toast.makeText(this, select, Toast.LENGTH_LONG).show()

                when (select) {
                    "Above 9" -> {
                        score += 5
                        acaScore += 5
                    }
                    "Above 8" -> {
                        score += 4
                        acaScore += 4
                    }
                    "Above 7" -> {
                        score += 3
                        acaScore += 3
                    }
                    "Below 7" -> {
                        score += 2
                        acaScore += 2
                    }
                }
            }

            // Rank in college
            val selectedRadioButtonIdCLGRank = binding.classCLGScoreRadioGroup.checkedRadioButtonId
            if (selectedRadioButtonIdCLGRank != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonIdCLGRank)
                val select = selectedRadioButton.text.toString()

                Toast.makeText(this, select, Toast.LENGTH_LONG).show()

                when (select) {
                    "Top 10% in your batch and branch" -> {
                        score += 2
                        acaScore += 2
                    }
                    "Top 25%" -> {
                        score += 1
                        acaScore += 1
                    }
                    "Below 25%" -> {
                        score += 0
                        acaScore += 0
                    }
                }
            }

            // Rank in university
            val selectedRadioButtonIdUNIRank = binding.classUGSScoreRadioGroup.checkedRadioButtonId
            if (selectedRadioButtonIdUNIRank != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonIdUNIRank)
                val select = selectedRadioButton.text.toString()

                Toast.makeText(this, select, Toast.LENGTH_LONG).show()

                when (select) {
                    "Top 10" -> {
                        score += 3
                        acaScore += 3
                    }
                    "10-25" -> {
                        score += 2
                        acaScore += 2
                    }
                    "25-50" -> {
                        score += 1
                        acaScore += 1
                    }
                    "50 +" -> {
                        score += 0
                        acaScore += 0
                    }
                }
            }

            Toast.makeText(this, score.toString(), Toast.LENGTH_LONG).show()


            val intent = Intent(this, NotableAchievements::class.java)
            intent.putExtra("AcademicScore", acaScore)
            intent.putExtra("score", score)
            startActivity(intent)

        }
    }
}