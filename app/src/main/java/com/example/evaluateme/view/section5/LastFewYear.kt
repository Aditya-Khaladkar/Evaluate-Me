package com.example.evaluateme.view.section5

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.evaluateme.R
import com.example.evaluateme.databinding.ActivityLastFewYearBinding
import com.example.evaluateme.view.section6.BusinessAchieved

class LastFewYear : AppCompatActivity() {
    lateinit var binding: ActivityLastFewYearBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLastFewYearBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val acaScore: Int = intent.getIntExtra("AcademicScore", 0)
        val nScore: Int = intent.getIntExtra("nScore", 0)

        var score: Int = intent.getIntExtra("score", 0)

        var laScore = 0

        // condition for extra activities
        binding.lastFewYrRadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.lastFewYrYES -> {
                    score += 3
                    laScore += 3
                    binding.lastFewYrRadioGroupActivity.visibility = View.VISIBLE
                }
                R.id.lastFewYrNO -> {
                    binding.lastFewYrRadioGroupActivity.visibility = View.GONE
                }
                else -> {}
            }
        }

        // btn onClick
        binding.btnFewAchieveNext.setOnClickListener {
            if (binding.ngoCheckBox.isChecked) {
                score += 2
                laScore += 2
            } else if (binding.collegeClubsCheckBox.isChecked) {
                score += 2
                laScore += 2
            } else if (binding.sportsCheckBox.isChecked) {
                score += 2
                laScore += 2
            } else if (binding.zonalSportsCheckBox.isChecked) {
                score += 3
                laScore += 3
            } else if (binding.stateSportsCheckBox.isChecked) {
                score += 4
                laScore += 4
            } else if (binding.nationalSportsCheckBox.isChecked) {
                score += 5
                laScore += 5
            } else if (binding.theatreReputedCheckBox.isChecked) {
                score += 5
                laScore += 5
            } else if (binding.artsRecreationCheckBox.isChecked) {
                score += 2
                laScore += 2
            } else if (binding.competitionsCheckBox.isChecked) {
                score += 3
                laScore += 3
            }

            // for extra activities
            val selectedRadioButtonId = binding.lastFewYrRadioGroupActivity.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val select = selectedRadioButton.text.toString()

                Toast.makeText(this, select, Toast.LENGTH_LONG).show()

                when (select) {
                    "Just participated as a hobby" -> {
                        score += 1
                        laScore += 1
                    }
                    "I was on the organizing team of such events" -> {
                        score += 1
                        laScore += 1
                    }
                    "I was in the leadership position for these activities" -> {
                        score += 2
                        laScore += 2
                    }
                }
            }

            Toast.makeText(this, score.toString(), Toast.LENGTH_LONG).show()

            val intent = Intent(this, BusinessAchieved::class.java)
            intent.putExtra("nScore", nScore)
            intent.putExtra("AcademicScore", acaScore)
            intent.putExtra("laScore", laScore)
            intent.putExtra("score", score)
            startActivity(intent)
        }

    }
}