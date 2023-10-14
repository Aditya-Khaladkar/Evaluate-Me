package com.example.evaluateme.view.section2

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.evaluateme.databinding.ActivityQuesGenderBinding
import com.example.evaluateme.view.section3.AcademicDetails

class QuesGender : AppCompatActivity() {
    lateinit var binding: ActivityQuesGenderBinding
    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuesGenderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.selectButton.setOnClickListener {

            val selectedRadioButtonId = binding.genderRadioGroup.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val selectGender = selectedRadioButton.text.toString()

                Toast.makeText(this, selectGender, Toast.LENGTH_LONG).show()

                if (selectGender == "Female") {
                    score += 2
                }

                val intent = Intent(this, AcademicDetails::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
    }
}