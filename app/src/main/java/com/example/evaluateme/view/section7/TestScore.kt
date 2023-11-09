package com.example.evaluateme.view.section7

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.evaluateme.R
import com.example.evaluateme.databinding.ActivityTestScoreBinding
import com.example.evaluateme.view.section8.WorkExperience

class TestScore : AppCompatActivity() {
    lateinit var binding: ActivityTestScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestScoreBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val acaScore: Int = intent.getIntExtra("AcademicScore", 0)
        val nScore: Int = intent.getIntExtra("nScore", 0)
        val laScore: Int = intent.getIntExtra("laScore", 0)
        val businessScore: Int = intent.getIntExtra("businessScore", 0)

        var score: Int = intent.getIntExtra("score", 0)

        var testScore = 0

        binding.greSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p1 > 335) {
                    score += 25
                    testScore += 25
                } else if (p1 > 330) {
                    score += 24
                    testScore += 24
                } else if (p1 in 329..329) {
                    score += 22
                    testScore += 22
                } else if (p1 in 325 .. 328) {
                    score += 20
                    testScore += 20
                } else if (p1 in 320 .. 325) {
                    score += 18
                    testScore += 18
                } else if (p1 < 320) {
                    score += 15
                    testScore += 15
                }
                binding.txtGreScore.text = "GRE Score: ${p1.toString()}"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        binding.gmatSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p1 >= 760) {
                    score += 25
                    testScore += 25
                } else if (p1 >= 740) {
                    score += 24
                    testScore += 24
                } else if (p1 in 700..730) {
                    score += 22
                    testScore += 22
                } else if (p1 in 650..690) {
                    score += 19
                    testScore += 19
                } else if (p1 < 650) {
                    score += 15
                    testScore += 15
                }
                binding.txtGMATScore.text = "GMAT Score: ${p1.toString()}"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        // btn onClick
        binding.btnTestScoreNext.setOnClickListener {

            val intent = Intent(this, WorkExperience::class.java)
            intent.putExtra("score", score)
            intent.putExtra("nScore", nScore)
            intent.putExtra("AcademicScore", acaScore)
            intent.putExtra("laScore", laScore)
            intent.putExtra("businessScore", businessScore)
            intent.putExtra("testScore", testScore)
            startActivity(intent)
        }

    }
}