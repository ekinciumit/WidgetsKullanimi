package com.example.widgetskullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.widgetskullanimi.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOku.setOnClickListener() {
            val alinanVeri = binding.editTextTextGirdi.text.toString()
            binding.textViewSonuc.text = alinanVeri
        }

        binding.buttonResim1.setOnClickListener() {
            binding.imageView.setImageResource(R.drawable.resim1)
        }

        binding.buttonResim2.setOnClickListener() {
            binding.imageView.setImageResource(
                resources.getIdentifier(
                    "resim2",
                    "drawable",
                    packageName
                )
            )
        }


        binding.switch1.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                    Log.e("Widgets","Switch : ON")
            }
            else{
                    Log.e( "Widgets","Switch : OFF")
            }

        }
    }
}