package com.example.bettercalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {


    //Basics
    private var result = 0
    private var partialResult = 0
    private var resultText = ""

    private val initialValue = "0"

    //Views
    private var resultTextView:TextView = findViewById(R.id.resultView)
    private var previousResultTextView:TextView = findViewById(R.id.textView)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = initialValue
        updateDisplay()

        val buttonZero: Button = findViewById(R.id.buttonNumber0)
        val buttonZeroZero:Button = findViewById(R.id.buttonNumber00)


        buttonZero.setOnClickListener {addDigits("0")}
        buttonZeroZero.setOnClickListener {addDigits("00")}


    }

    private fun addDigits(operation: String) {
        resultText += operation
        updateDisplay()

    }
    private fun updateDisplay() {
        resultTextView.text = resultText
    }

    private fun
}