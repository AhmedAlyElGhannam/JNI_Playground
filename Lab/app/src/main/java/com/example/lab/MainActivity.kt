package com.example.lab

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.lab.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FactorialHelperJava.calcFactorial(6);

    }


    /**
     * A native method that is implemented by the 'lab' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'lab' library on application startup.
        init {
            System.loadLibrary("lab")
        }

        private lateinit var binding: ActivityMainBinding


        var res : Long = 0

        @SuppressLint("SetTextI18n")
        @JvmStatic
        fun updateUI(_res : Long) {
            res = _res
            binding.factResult.text = res.toString()
        }
    }
}