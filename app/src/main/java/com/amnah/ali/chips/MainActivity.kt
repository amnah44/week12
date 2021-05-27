package com.amnah.ali.chips

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amnah.ali.chips.databinding.ActivityMainBinding
import com.google.android.material.chip.Chip

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun addChips(view:View){
        try {
            val text_array = binding.enterChips.text!!.toString().split(" ".toRegex())
                .dropLastWhile { it.isEmpty() }.toTypedArray()

            val inflates = LayoutInflater.from(this@MainActivity)
            for (item in text_array) {
                val chips = inflates.inflate(R.layout.chips_item,null, false) as Chip
                chips.apply {
                    text = item
                    setChipBackgroundColorResource(R.color.teal_200)
                    setTextColor(Color.WHITE)
                    textSize = 24F
                    setOnCloseIconClickListener {
                        binding.chipsGroup.removeView(it)
                    }
                }
                binding.chipsGroup.addView(chips)
            }
        }catch (e:Exception){
            e.printStackTrace()
            Toast.makeText(this, "Error: " + e.message, Toast.LENGTH_LONG).show()
        }
    }
}