package com.example.bettercalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bettercalc.fragments.Calculator
import com.example.bettercalc.fragments.HistoryOfCalculator
import com.example.bettercalc.fragments.MoreFunctions
import com.example.bettercalc.fragments.ScientificFuntions
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