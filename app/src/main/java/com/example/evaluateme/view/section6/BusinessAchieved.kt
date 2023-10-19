package com.example.evaluateme.view.section6

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.evaluateme.R
import com.example.evaluateme.databinding.ActivityBusinessAchievedBinding
import com.example.evaluateme.view.section7.TestScore

class BusinessAchieved : AppCompatActivity() {
    lateinit var binding: ActivityBusinessAchievedBinding
    lateinit var sharedPref: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBusinessAchievedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPref = getSharedPreferences("ScorePref", Context.MODE_PRIVATE)

        var score: Int = intent.getIntExtra("score", 0)

        var businessScore = 0

        // condition for certificate
        binding.CertificationsRadioGroup.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.CertificationsYES -> {
                    binding.CertificationsRadioGroupActivity.visibility = View.VISIBLE
                }
                R.id.CertificationsNO -> {
                    binding.CertificationsRadioGroupActivity.visibility = View.GONE
                }
                else -> {}
            }
        }

        // btn onClick
        binding.btnBusinessNext.setOnClickListener {
            if (binding.successfulEntrepreneurCheckBox.isChecked) {
                score += 5
                businessScore += 5
            } else if (binding.startupExposureCheckBox.isChecked) {
                score += 3
                businessScore += 3
            } else if (binding.highRevenueProjectsCheckBox.isChecked) {
                score += 4
                businessScore += 4
            }

            // for certificate
            if (binding.certificateSixSigma.isChecked) {
                score += 3
                businessScore += 3
            } else if (binding.certificateYellowBelt.isChecked) {
                score += 2
                businessScore += 2
            } else if (binding.certificateCFA23.isChecked) {
                score += 3
                businessScore += 3
            } else if (binding.certificateCFA1.isChecked) {
                score += 2
                businessScore += 2
            } else if (binding.certificateFRM12.isChecked) {
                score += 2
                businessScore += 2
            } else if (binding.certificateCA.isChecked) {
                score += 4
                businessScore += 4
            }

            val edit = sharedPref.edit()
            edit.putInt("businessScore", businessScore)

            val intent = Intent(this, TestScore::class.java)
            intent.putExtra("score", score)
            startActivity(intent)
        }
    }
}