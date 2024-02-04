package com.example.mainprokect

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var currentValue: Int = 45
    private lateinit var counterTextView: TextView


    private lateinit var buttonReset: Button
    private lateinit var resultText: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonReset = findViewById(R.id.buttonReset)

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

    @SuppressLint("SetTextI18n")
    fun checkNumber() {
        if (currentValue in 0..49) {
            buttonReset.visibility = View.GONE
        } else {
            buttonReset.visibility = View.VISIBLE
        }
        when (currentValue) {
            0 -> {
                resultText.text = "Все места свободны"
                resultText.setTextColor(Color.GREEN)
            }
            in 1..49 -> {
                resultText.text = "Осталось мест: ${50 - currentValue}"
                resultText.setTextColor(Color.BLACK)
            }
            50 -> {
                resultText.text = "Пассажиров слижком много"
                resultText.setTextColor(Color.RED)
            }
        }
    }
}