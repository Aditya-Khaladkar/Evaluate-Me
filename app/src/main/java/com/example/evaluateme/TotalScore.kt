package com.example.evaluateme

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.evaluateme.databinding.ActivityTestScoreBinding
import com.example.evaluateme.databinding.ActivityTotalScoreBinding

class TotalScore : AppCompatActivity() {
    lateinit var binding: ActivityTotalScoreBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTotalScoreBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val acaScore: Int = intent.getIntExtra("AcademicScore", 0)
        val nScore: Int = intent.getIntExtra("nScore", 0)
        val laScore: Int = intent.getIntExtra("laScore", 0)
        val businessScore: Int = intent.getIntExtra("businessScore", 0)
        val testScore: Int = intent.getIntExtra("testScore", 0)
        val workExp: Int = intent.getIntExtra("workExp", 0)


        var score: Int = intent.getIntExtra("score", 0)
        binding.finalScore.text = score.toString()


        binding.academicScoreTextview.text = "Academic Score: $acaScore"
        binding.notableAchievementsTextview.text = "Notable Achievements: $nScore"
        binding.collegeActivityTextview.text = "College Activity: $laScore"
        binding.businessAchievementsTextview.text = "Business Achievements Score: $businessScore"
        binding.greGmatTextview.text = "GRE / GMAT Score: $testScore"
        binding.workExperienceTextview.text = "Work Experience Score: $workExp"


    }
}