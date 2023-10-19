package com.example.evaluateme.view.section4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.evaluateme.R
import com.example.evaluateme.databinding.ActivityNotableAchievementsBinding
import com.example.evaluateme.view.section5.LastFewYear

class NotableAchievements : AppCompatActivity() {
    lateinit var binding: ActivityNotableAchievementsBinding
    lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotableAchievementsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = getSharedPreferences("ScorePref", Context.MODE_PRIVATE)

        var score: Int = intent.getIntExtra("score", 0)

        var nScore = 0

        binding.btnAchieveNext.setOnClickListener {
            if (binding.meritScholarshipCheckBox.isChecked) {
                score += 3
                nScore += 3
            } else if (binding.academicProjectsCheckBox.isChecked) {
                score += 3
                nScore += 3
            } else if (binding.patentCheckBox.isChecked) {
                score += 4
                nScore += 4
            } else if (binding.researchInternshipCheckBox.isChecked) {
                score += 4
                nScore += 4
            }

            Toast.makeText(this, score.toString(), Toast.LENGTH_LONG).show()

            val editor = sharedPref.edit()
            editor.putInt("NotableScore", nScore)

            val intent = Intent(this, LastFewYear::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
        }
    }
}