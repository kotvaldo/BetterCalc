package com.example.bettercalc.Fragments

import android.graphics.Color
import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.example.bettercalc.R
import com.example.bettercalc.databinding.ActivityMainBinding
import com.example.bettercalc.databinding.FragmentCalculatorBinding

class Calculator : Fragment(), OnClickListener {

    private lateinit var binding: FragmentCalculatorBinding
    //Basics //Basics

    private var valueList = arrayListOf<String>()

    private var wasDotClicked = false

    private var resultText = ""
    private var fullText = ""
    private var isOperatorClicked = false

    private val initialValue = "0"

    //Views
    private lateinit var resultTextView: TextView
    private lateinit var fullTextView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCalculatorBinding.inflate(layoutInflater)

        resultText = initialValue
        resultTextView = binding.resultView
        fullTextView = binding.fullTextView
        updateDisplay()
        val buttonList = listOf (
            binding.buttonNumber0,
            binding.buttonNumber00,
            binding.buttonDot,
            binding.buttonEquals,
            binding.buttonNumber1,
            binding.buttonNumber2,
            binding.buttonNumber3,
            binding.buttonPlus,
            binding.buttonNumber4,
            binding.buttonNumber5,
            binding.buttonNumber6,
            binding.buttonMinus,
            binding.buttonNumber7,
            binding.buttonNumber8,
            binding.buttonNumber9,
            binding.buttonMult,
            binding.buttonDiv,
            binding.buttonClear,
            binding.buttonPerc,
            binding.buttonParentLeft,
            binding.buttonParentRight,
            binding.buttonPower,
            binding.buttonMore,
            binding.buttonBackspace,
        ).forEach { it.setOnClickListener(this)

        }
        valueList = arrayListOf(
            "0",
            "00",
            ".",
            "+",
            "-",
            "*",
            "/",
            "^",
            "(",
            ")",
            "%",
        )



        // Inflate the layout for this fragment
        return binding.root
    }



    private fun updateDisplay() {
        if(clearCheck()) {
            resultTextView.text = resultText
        } else resultTextView.text = "= $resultText"
        fullTextView.text = fullText
    }

    private fun clearDisplay() {
        resultTextView.currentTextColor == Color.WHITE
        resultText = initialValue
        fullText = ""
        updateDisplay()


    }

    private fun clearCheck(): Boolean {
        if (resultText == "0" && fullText.isEmpty()) return true
        return false
    }

    private fun updateResult() {
        if(clearCheck()) {

        } else {
            resultTextView.currentTextColor == Color.GRAY
            fullTextView.currentTextColor == Color.WHITE

            if (isOperatorClicked) {

            } else {

            }
        }


    }
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.buttonNumber0 -> {
                if(!clearCheck()) {
                    fullText += valueList[0]
                } else {

                }

            }
            R.id.buttonNumber00 -> {
                if(!clearCheck()) {
                    fullText += valueList[1]
                } else {
                }

            }
            R.id.buttonDot -> {
                if(clearCheck()) {
                    if(!wasDotClicked) {
                        fullText += "0" + valueList[2]
                        wasDotClicked = !wasDotClicked
                    }
                } else {
                    if(!wasDotClicked) {
                        fullText += "0" + valueList[2]
                        wasDotClicked = !wasDotClicked
                    }
                }

            }
            R.id.buttonEquals -> {}
            R.id.buttonNumber1 -> { fullText += "1"}
            R.id.buttonNumber2 -> { fullText += "2"}
            R.id.buttonNumber3 -> { fullText += "3"}
            R.id.buttonNumber4 -> { fullText += "4"}
            R.id.buttonNumber5 -> { fullText += "5"}
            R.id.buttonNumber6 -> { fullText += "6"}
            R.id.buttonNumber7 -> { fullText += "7"}
            R.id.buttonNumber8 -> { fullText += "8"}
            R.id.buttonNumber9 -> { fullText += "9"}


            
            R.id.buttonPlus -> { fullText += valueList[3]}
            R.id.buttonMinus -> { fullText += valueList[4]}
            R.id.buttonMult -> { fullText += valueList[5]}
            R.id.buttonDiv  -> { fullText += valueList[6]}
            R.id.buttonPower  -> { fullText += valueList[7]}
            R.id.buttonParentLeft  -> { fullText += valueList[8]}
            R.id.buttonParentRight  -> { fullText += valueList[9]}
            R.id.buttonPerc  -> { fullText += valueList[10]}

            R.id.buttonClear -> { clearDisplay() }


        }
    updateDisplay()
    updateResult()
    }
}