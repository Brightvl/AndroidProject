package com.example.mainprokect

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var currentValue: Int = 0
    private lateinit var counterTextView: TextView
    private lateinit var resultText: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonReset: Button = findViewById(R.id.buttonReset)

        resultText = findViewById(R.id.resultText)

        val buttonMinus: Button = findViewById(R.id.buttonMinus)

        counterTextView = findViewById(R.id.counterTextView)

        val buttonPlus: Button = findViewById(R.id.buttonPlus)

        buttonReset.setOnClickListener { resetCounter() }
        buttonMinus.setOnClickListener { decreaseCounter() }
        buttonPlus.setOnClickListener { increaseCounter() }

        updateCounterText()
    }

    private fun resetCounter() {
        currentValue = 0
        updateCounterText()
    }

    private fun decreaseCounter() {
        if (currentValue in 1..50) {
            currentValue--
            updateCounterText()
        }
    }

    private fun increaseCounter() {
        // Увеличиваем значение и обновляем текстовое поле
        if (currentValue in 0..49) {
            currentValue++
            updateCounterText()
        }

    }

    private fun updateCounterText() {
        // Обновляем текст в TextView
        counterTextView.text = currentValue.toString()
        checkNumber()
    }

    fun checkNumber() {
        if (currentValue == 0) {
            resultText.text = "Все места свободны"
        } else if (currentValue in 1..49) {
            resultText.text = "Осталось мест: ${50 - currentValue}"
        } else if (currentValue == 50) {
            resultText.text = "Пассажиров слижком много"
        }
    }
}