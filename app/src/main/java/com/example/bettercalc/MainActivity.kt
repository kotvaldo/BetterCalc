package com.example.bettercalc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bettercalc.Fragments.Calculator
import com.example.bettercalc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = Calculator()
        replaceFragment(homeFragment)

        

    }

    private fun replaceFragment(fragment:Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()

    }
}