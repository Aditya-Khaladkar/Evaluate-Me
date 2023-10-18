package com.example.evaluateme.view.section7

import android.content.Intent
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

        var score: Int = intent.getIntExtra("score", 0)

        binding.greSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                score += p1
                binding.txtGreScore.text = "GRE Score: ${p1.toString()}"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        binding.gmatSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                score += p1
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
            startActivity(intent)
        }

    }
}