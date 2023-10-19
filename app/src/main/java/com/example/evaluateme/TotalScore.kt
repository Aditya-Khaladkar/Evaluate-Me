package com.example.evaluateme

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.evaluateme.databinding.ActivityTestScoreBinding
import com.example.evaluateme.databinding.ActivityTotalScoreBinding

class TotalScore : AppCompatActivity() {
    lateinit var binding: ActivityTotalScoreBinding
    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTotalScoreBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = getSharedPreferences("ScorePref", Context.MODE_PRIVATE)

        var result = 0

        var score: Int = intent.getIntExtra("score", 0)
        binding.finalScore.text = score.toString()

//        Handler().postDelayed(Runnable {
//            while (result == score) {
//                result++
//                binding.finalScore.text = result.toString()
//
//            }
//        }, 1000)

        binding.academicScoreTextview.text = "Academic Score: ${sharedPref.getInt("AcademicScore", 0).toString()}"
        binding.notableAchievementsTextview.text = "Notable Achievements: ${sharedPref.getInt("NotableScore", 0).toString()}"
        binding.collegeActivityTextview.text = "College Activity Score: ${sharedPref.getInt("LaScore", 0).toString()}"
        binding.businessAchievementsTextview.text = "Business Achievements Score: ${sharedPref.getInt("businessScore", 0).toString()}"
        binding.greGmatTextview.text = "GRE / GMAT Score: ${sharedPref.getInt("testScore", 0).toString()}"
        binding.workExperienceTextview.text = "Work Experience Score: ${
            sharedPref.getInt(
                "companyType",
                0
            ) + sharedPref.getInt("workExp", 0)
        }"
    }
}