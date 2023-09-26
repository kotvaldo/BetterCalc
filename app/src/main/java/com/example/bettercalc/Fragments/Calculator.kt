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
            binding.buttonBackwards,
            binding.buttonBackspace,
        ).forEach { it.setOnClickListener(this)

        }
        valueList = arrayListOf(
            "0",
            "00",
            ".",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
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
    private fun findIndex(string: String ) : Int {

    }
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.buttonNumber0 -> {
                if(!clearCheck()) {
                    fullText += valueList[findIndex("0")]
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
                fullText += valueList[2]

            }
            R.id.buttonEquals -> {}
            R.id.buttonNumber1 -> { fullText += valueList[]}
            R.id.buttonNumber2 -> {}
            R.id.buttonNumber3 -> {}
            R.id.buttonPlus -> {}
            R.id.buttonNumber4 -> {}
            R.id.buttonNumber5 -> {}
            R.id.buttonNumber6 -> {}
            R.id.buttonNumber0 -> {}
            R.id.buttonNumber0 -> {}

        }
    }
}