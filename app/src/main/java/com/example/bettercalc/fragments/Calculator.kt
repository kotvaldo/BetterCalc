package com.example.bettercalc.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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
    private var isLeftParentClicked = false
    private var isRightParentClicked = false
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
            binding.buttonSqrt,
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
            ".",
        )

        operatorsValue = arrayListOf(
            "+",
            "-",
            "*",
            "/",
            "^",
            "%",
            "√"
        )

        // Inflate the layout for this fragment
        return binding.root
    }


    private fun updateDisplay() {
        fullTextView.text = fullText
    }

    private fun clearDisplay() {
        resultText = initialValue
        fullText = ""
        updateDisplay()


    }

    private fun clearCheck(): Boolean {
        if (resultText == "0" && fullText.isEmpty()) return true
        return false
    }

    private fun makeResult() {
        if (controlAllText(fullText)) {


        }

    }

    private fun updateResult() {
        resultTextView.text = resultText
    }

    private fun controlAllText(fullText: String): Boolean {
        if (!controlParent(fullText)) {
            Toast.makeText(requireContext(), "Syntax Error", Toast.LENGTH_SHORT)
            return false
        }


        return true
    }

    private fun controlParent(fullText: String): Boolean {
        val stack = mutableListOf<Int>()

        for (i in fullText.indices) {
            when (fullText[i]) {
                '(' -> stack.add(i)
                ')' -> {
                    if (stack.isEmpty()) {
                        return false
                    }
                    stack.removeAt(stack.size - 1)
                }
            }
        }
        return stack.isEmpty()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.buttonNumber0 -> {
                if(!clearCheck())
                    handleNumber(valueList[0])
            }
            R.id.buttonNumber00 -> {
                if(!clearCheck())
                    handleNumber(valueList[1])
            }
            R.id.buttonNumber1 -> handleNumber(valueList[2])
            R.id.buttonNumber2 -> handleNumber(valueList[3])
            R.id.buttonNumber3 -> handleNumber(valueList[4])
            R.id.buttonNumber4 -> handleNumber(valueList[5])
            R.id.buttonNumber5 -> handleNumber(valueList[6])
            R.id.buttonNumber6 -> handleNumber(valueList[7])
            R.id.buttonNumber7 -> handleNumber(valueList[8])
            R.id.buttonNumber8 -> handleNumber(valueList[9])
            R.id.buttonNumber9 -> handleNumber(valueList[10])
            R.id.buttonPlus -> handleOperator(operatorsValue[0])
            R.id.buttonMinus -> handleOperator(operatorsValue[1])
            R.id.buttonMult -> handleOperator(operatorsValue[2])
            R.id.buttonDiv -> handleOperator(operatorsValue[3])
            R.id.buttonPower -> handleOperator(operatorsValue[4])
            R.id.buttonPerc -> handleOperator(operatorsValue[5])
            R.id.buttonSqrt -> handleOperator(operatorsValue[6])
            R.id.buttonDot -> {
                if (!wasDotClicked && !isOperatorClicked) {
                    fullText += valueList[11]
                    wasDotClicked = true
                }
            }

            R.id.buttonClear -> {
                clearDisplay()
            }

            R.id.buttonBackspace -> {
                fullText = fullText.dropLast(1)
            }

            R.id.buttonEquals -> {
                makeResult()


            }

        }
        updateDisplay()
    }

    private fun handleOperator(operator: String) {
        if (wasDotClicked) {
            fullText += "0"
            wasDotClicked = false
        }
        if (isOperatorClicked) {
            fullText = fullText.dropLast(2)
        } else {
            isOperatorClicked = true
        }
        fullText = fullText.trim() + " " + operator + " "
    }

    private fun handleNumber(number: String) {
        fullText += number
        if (isOperatorClicked) {
            isOperatorClicked = false
        }
        if (wasDotClicked) {
            wasDotClicked = false
        }
    }
}