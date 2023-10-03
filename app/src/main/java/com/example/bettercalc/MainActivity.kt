package com.example.bettercalc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bettercalc.Fragments.Calculator
import com.example.bettercalc.Fragments.HistoryOfCalculator
import com.example.bettercalc.Fragments.MoreFunctions
import com.example.bettercalc.Fragments.ScientificFuntions
import com.example.bettercalc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = Calculator()
        replaceFragment(homeFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.btn_fnc -> replaceFragment(MoreFunctions())
                R.id.btn_calc -> replaceFragment(Calculator())
                R.id.btn_doll -> replaceFragment(ScientificFuntions())
                R.id.btn_history -> replaceFragment(HistoryOfCalculator())
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()

    }
}