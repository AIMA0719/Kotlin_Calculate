package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!
    private val numbers = listOf(
        "%", "/", "^", "←",
        "1", "2", "3", "+",
        "4", "5", "6", "-",
        "7", "8", "9", "*",
        ".", "0", "=", "C"
    )
    private lateinit var keypadAdapter: KeypadAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvKeyPad.layoutManager = GridLayoutManager(this,4)

        keypadAdapter = KeypadAdapter()
        keypadAdapter.setNumbers(numbers)
        keypadAdapter.setOnItemClickListener { key -> binding.tvResult.text = calculateNumber(key) }

        binding.rvKeyPad.adapter = keypadAdapter
    }

    private fun calculateNumber(number:String):String {
        when (number) {
            "1" -> return "3"
            "2" -> return "1"
            "3" -> return "1"
            "4" -> return "1"
            "5" -> return "1"
            "6" -> return "1"
            "7" -> return "1"
            "8" -> return "1"
            "9" -> return "1"
            "0" -> return "1"
            "." -> return "1"
            "=" -> return "1"
            "+" -> return "1"
            "-" -> return "1"
            "*" -> return "1"
            "%" -> return "1"
            "/" -> return "1"
            "^" -> return "1"
            "←" -> return "1"

        }
        return number
    }


    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}