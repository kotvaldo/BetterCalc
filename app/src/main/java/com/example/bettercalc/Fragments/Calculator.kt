package com.example.bettercalc.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bettercalc.R
import com.example.bettercalc.databinding.FragmentCalculatorBinding

class Calculator : Fragment(), OnClickListener {

    private lateinit var binding: FragmentCalculatorBinding
    //Basics //Basics

    private var valueList = arrayListOf<String>()
    private var operatorsValue = arrayListOf<String>()
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
        val buttonList = listOf(
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
        ).forEach {
            it.setOnClickListener(this)

        }
        valueList = arrayListOf(
            "0",
            "00",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "(",
            ")",
            ".",
        )

        operatorsValue = arrayListOf(
            "+",
            "-",
            "*",
            "/",
            "^",
            "%",
        )

        // Inflate the layout for this fragment
        return binding.root
    }


    private fun updateDisplay() {
        if (clearCheck()) {
            resultTextView.currentTextColor == Color.GRAY
        }
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
        if (clearCheck()) {

        } else {
            resultTextView.currentTextColor == Color.GRAY
            if (isOperatorClicked) {

            } else {
                resultText = fullText
            }
        }


    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.buttonNumber0 -> {
                if (!clearCheck()) {
                    fullText += valueList[0]
                } else {

                }

            }

            R.id.buttonNumber00 -> {
                if (!clearCheck()) {
                    fullText += valueList[1]
                } else {
                }

            }

            R.id.buttonDot -> {
                if(!clearCheck()) {
                    if (!wasDotClicked && !isOperatorClicked) {
                        fullText += valueList[13]
                        wasDotClicked = !wasDotClicked
                    }
                }

            }

            R.id.buttonEquals -> {}
            R.id.buttonNumber1 -> {
                fullText += valueList[2]
                if (isOperatorClicked) isOperatorClicked = !isOperatorClicked
                if (wasDotClicked) wasDotClicked = !wasDotClicked
            }

            R.id.buttonNumber2 -> {
                fullText += valueList[3]
                if (isOperatorClicked) isOperatorClicked = !isOperatorClicked
                if (wasDotClicked) wasDotClicked = !wasDotClicked
            }

            R.id.buttonNumber3 -> {
                fullText += valueList[4]
                if (isOperatorClicked) isOperatorClicked = !isOperatorClicked
                if (wasDotClicked) wasDotClicked = !wasDotClicked
            }

            R.id.buttonNumber4 -> {
                fullText += valueList[5]
                if (isOperatorClicked) isOperatorClicked = !isOperatorClicked
                if (wasDotClicked) wasDotClicked = !wasDotClicked
            }

            R.id.buttonNumber5 -> {
                fullText += valueList[6]
                if (isOperatorClicked) isOperatorClicked = !isOperatorClicked
                if (wasDotClicked) wasDotClicked = !wasDotClicked
            }

            R.id.buttonNumber6 -> {
                fullText += valueList[7]
                if (isOperatorClicked) isOperatorClicked = !isOperatorClicked
                if (wasDotClicked) wasDotClicked = !wasDotClicked
            }

            R.id.buttonNumber7 -> {
                fullText += valueList[8]
                if (isOperatorClicked) isOperatorClicked = !isOperatorClicked
                if (wasDotClicked) wasDotClicked = !wasDotClicked
            }

            R.id.buttonNumber8 -> {
                fullText += valueList[9]
                if (isOperatorClicked) isOperatorClicked = !isOperatorClicked
                if (wasDotClicked) wasDotClicked = !wasDotClicked
            }

            R.id.buttonNumber9 -> {
                fullText += valueList[10]
                if (isOperatorClicked) isOperatorClicked = !isOperatorClicked
                if (wasDotClicked) wasDotClicked = !wasDotClicked
            }


            R.id.buttonPlus -> {
                if(wasDotClicked) {
                    fullText += "0"
                    wasDotClicked = false
                }
                if (isOperatorClicked) {
                    fullText = fullText.dropLast(1)
                    fullText += operatorsValue[0]

                } else {
                    isOperatorClicked = !isOperatorClicked
                    fullText += operatorsValue[0]
                }

            }

            R.id.buttonMinus -> {
                if(wasDotClicked) {
                    fullText += "0"
                    wasDotClicked = false
                }
                if (isOperatorClicked) {
                    fullText = fullText.dropLast(1)
                    fullText += operatorsValue[1]

                } else {
                    isOperatorClicked = !isOperatorClicked
                    fullText += operatorsValue[1]
                }

            }

            R.id.buttonMult -> {
                if(wasDotClicked) {
                    fullText += "0"
                    wasDotClicked = false
                }
                if (isOperatorClicked) {
                    fullText = fullText.dropLast(1)
                    fullText += operatorsValue[2]

                } else {
                    isOperatorClicked = !isOperatorClicked
                    fullText += operatorsValue[2]
                }
            }

            R.id.buttonDiv -> {
                if(wasDotClicked) {
                    fullText += "0"
                    wasDotClicked = false
                }
                if (isOperatorClicked) {
                    fullText = fullText.dropLast(1)
                    fullText += operatorsValue[3]

                } else {
                    isOperatorClicked = !isOperatorClicked
                    fullText += operatorsValue[3]
                }
            }

            R.id.buttonPower -> {
                if(wasDotClicked) {
                    fullText += "0"
                    wasDotClicked = false
                }
                if (isOperatorClicked) {
                    fullText = fullText.dropLast(1)
                    fullText += operatorsValue[4]

                } else {
                    isOperatorClicked = !isOperatorClicked
                    fullText += operatorsValue[4]
                }
            }

            R.id.buttonPerc -> {
                if(wasDotClicked) {
                    fullText += "0"
                    wasDotClicked = false
                }
                if (isOperatorClicked) {
                    fullText = fullText.dropLast(1)
                    fullText += operatorsValue[5]

                } else {
                    isOperatorClicked = !isOperatorClicked
                    fullText += operatorsValue[5]
                }
            }

            R.id.buttonParentLeft -> {
                fullText += valueList[11]
                if (isOperatorClicked) isOperatorClicked = !isOperatorClicked
            }

            R.id.buttonParentRight -> {
                fullText += valueList[12]
                if (isOperatorClicked) isOperatorClicked = !isOperatorClicked
            }


            R.id.buttonClear -> {
                clearDisplay()
            }

            R.id.buttonBackspace -> {
                fullText = fullText.dropLast(1)
            }

        }
        updateDisplay()
        updateResult()
    }
}