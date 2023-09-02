package com.example.bettercalc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.bettercalc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //Basics

    private var resultText = ""
    private var fullText = ""

    private var isClear = true
    private var isOperatorClicked = false

    private val initialValue = "0"

    //Views
    private lateinit var resultTextView:TextView
    private lateinit var fullTextView:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultText = initialValue
        resultTextView = binding.resultView
        fullTextView = binding.fullTextView
        updateDisplay()
        val buttonZero: Button = binding.buttonNumber0
        val buttonZeroZero:Button = binding.buttonNumber00
        val buttonOne:Button = binding.buttonNumber1
        val buttonTwo:Button = binding.buttonNumber2
        val buttonThree:Button = binding.buttonNumber3
        val buttonFour:Button = binding.buttonNumber4
        val buttonFive:Button = binding.buttonNumber5
        val buttonSix:Button = binding.buttonNumber6
        val buttonSeven:Button = binding.buttonNumber7
        val buttonEight:Button = binding.buttonNumber8
        val buttonNine:Button = binding.buttonNumber9

        val buttonPlus:Button = binding.buttonPlus
        val buttonMinus:Button = binding.buttonMinus
        val buttonMultiply:Button = binding.buttonMult
        val buttonDivide:Button = binding.buttonDiv
        val buttonDot:Button = binding.buttonDot

        val buttonAC:Button = binding.buttonClear
        val buttonBackspace: ImageButton = binding.buttonBackspace
        val buttonParLeft:Button = binding.buttonParentLeft
        val buttonParRight:Button = binding.buttonParentRight
        val buttonBackward: ImageButton = binding.buttonBackwards

        buttonZero.  {addDigits("0")}
        buttonZeroZero.setOnClickListener {addDigits("00")}
        buttonOne.setOnClickListener {addDigits("1")  }
        buttonTwo.setOnClickListener {addDigits("2")  }


    }

    private fun addDigits(operation: String) {
        when (operation) {
            "0" -> {
                if(clearCheck()) {

                } else {

                }

            }
            "00" -> {


            }

            "AC" -> {


            }

            else -> {
                if(clearCheck()) {

                } else {

                }

            }
        }

        updateDisplay()
    }


    private fun updateDisplay() {
        resultTextView.text = resultText
        fullTextView.text = fullText
    }

    private fun clearDisplay() {
        resultTextView.currentTextColor == Color.WHITE
        resultText = initialValue
        fullText = ""

        fullTextView.text == fullText
        resultTextView.text == resultText
        isClear = true;


    }

    private fun clearCheck() : Boolean {
        if(isClear) return true
        return false
    }

    private fun updateResult() {
        if(isOperatorClicked) {

        } else {

        }

    }

}