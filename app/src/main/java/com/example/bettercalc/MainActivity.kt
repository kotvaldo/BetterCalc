package com.example.bettercalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView


class MainActivity : AppCompatActivity() {


    //Basics
    private var result = 0
    private var partialResult = 0
    private var resultText = ""

    private val initialValue = "0"

    //Views
    private var resultTextView:TextView = findViewById(R.id.resultView)
    private var fullTextView:TextView = findViewById(R.id.fullTextView)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //resultText = initialValue
        //updateDisplay()

        /*val buttonZero: Button = findViewById(R.id.buttonNumber0)
        val buttonZeroZero:Button = findViewById(R.id.buttonNumber00)
        val buttonOne:Button = findViewById(R.id.buttonNumber1)
        val buttonTwo:Button = findViewById(R.id.buttonNumber2)
        val buttonThree:Button = findViewById(R.id.buttonNumber3)
        val buttonFour:Button = findViewById(R.id.buttonNumber4)
        val buttonFive:Button = findViewById(R.id.buttonNumber5)
        val buttonSix:Button = findViewById(R.id.buttonNumber6)
        val buttonSeven:Button = findViewById(R.id.buttonNumber7)
        val buttonEight:Button = findViewById(R.id.buttonNumber8)
        val buttonNine:Button = findViewById(R.id.buttonNumber9)

        val buttonPlus:Button = findViewById(R.id.buttonPlus)
        val buttonMinus:Button = findViewById(R.id.buttonMinus)
        val buttonMultiply:Button = findViewById(R.id.buttonMult)
        val buttonDivide:Button = findViewById(R.id.buttonDiv)
        val buttonDot:Button = findViewById(R.id.buttonDot)

        val buttonAC:Button = findViewById(R.id.buttonClear)
        val buttonBackspace: ImageButton = findViewById(R.id.buttonBackspace)
        val buttonParLeft:Button = findViewById(R.id.buttonParentLeft)
        val buttonParRight:Button = findViewById(R.id.buttonParentRight)

        buttonZero.setOnClickListener {addDigits("0")}
        buttonZeroZero.setOnClickListener {addDigits("00")}*/


    }

    private fun addDigits(operation: String) {
        resultText += operation
        updateDisplay()

    }
    private fun updateDisplay() {
        resultTextView.text = resultText
    }

    private fun clearDisplay() {


    }

}