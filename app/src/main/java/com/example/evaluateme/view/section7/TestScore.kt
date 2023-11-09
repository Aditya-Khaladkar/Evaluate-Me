package com.example.evaluateme.view.section7

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.Toast
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


        // btn onClick
        binding.btnTestScoreNext.setOnClickListener {


            // for GRE score
            val selectedRadioButtonIdGRE = binding.greScoreRadioGroup.checkedRadioButtonId
            if (selectedRadioButtonIdGRE != -1) {
                val selectedRadioButtonGRE = findViewById<RadioButton>(selectedRadioButtonIdGRE)
                val selectGRE = selectedRadioButtonGRE.text.toString()

                Toast.makeText(this, selectGRE, Toast.LENGTH_LONG).show()

                when (selectGRE) {
                    "335 +" -> {
                        score += 25
                        testScore += 25
                    }
                    "330 +" -> {
                        score += 24
                        testScore += 24
                    }
                    "328-330" -> {
                        score += 22
                        testScore += 22
                    }
                    "325 – 328" -> {
                        score += 20
                        testScore += 20
                    }
                    "320 – 325" -> {
                        score += 18
                        testScore += 18
                    }
                    "Below 320" -> {
                        score += 15
                        testScore += 15
                    }
                }
            }


            // for GMAT score
            val selectedRadioButtonIdGMAT = binding.gmatScoreRadioGroup.checkedRadioButtonId
            if (selectedRadioButtonIdGMAT != -1) {
                val selectedRadioButtonGMAT = findViewById<RadioButton>(selectedRadioButtonIdGMAT)
                val selectGMAT = selectedRadioButtonGMAT.text.toString()

                Toast.makeText(this, selectGMAT, Toast.LENGTH_LONG).show()

                when (selectGMAT) {
                    "760 +" -> {
                        score += 25
                        testScore += 25
                    }
                    "740 +" -> {
                        score += 24
                        testScore += 24
                    }
                    "700-730" -> {
                        score += 22
                        testScore += 22
                    }
                    "650 – 690" -> {
                        score += 19
                        testScore += 19
                    }
                    "Below 650" -> {
                        score += 15
                        testScore += 15
                    }
                }
            }


            Log.d("@debug", "onCreate: $testScore")

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