package com.example.widgetskullanimi

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.widgetskullanimi.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var kontrol = false
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
            binding.imageView.setImageResource(R.drawable.resim2)
        }


        binding.switch1.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) {
                    Log.e("Sonuc","Switch : ON")
            }
            else{
                    Log.e( "Sonuc","Switch : OFF")

            }

        }

        binding.ToggleButton.addOnButtonCheckedListener { group, checkedId, isChecked ->
            kontrol = isChecked
            if (kontrol){
                val secilenButon =findViewById<Button>(binding.ToggleButton.checkedButtonId)
                val buttonYazi = secilenButon.text.toString()
                Log.e("Sonuc" ,buttonYazi)
            }

        }

        val ulkeler =ArrayList<String>()
        ulkeler.add("Türkiye")
        ulkeler.add("İtalya")
        ulkeler.add("Japonya")
        ulkeler.add("Almanya")
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,ulkeler)
        binding.aoutoCompleteTextView.setAdapter(arrayAdapter)

        binding.buttonBasla.setOnClickListener{
            binding.progressBar.visibility = View.VISIBLE
        }

        binding.buttonDur.setOnClickListener{
            binding.progressBar.visibility = View.INVISIBLE
        }

        binding.buttonGoster.setOnClickListener{
            Log.e("Sonuc","Switch Durum : ${binding.switch1.isChecked}")
            if (kontrol){
                val secilenButon =findViewById<Button>(binding.ToggleButton.checkedButtonId)
                val buttonYazi = secilenButon.text.toString()
                Log.e("Sonuc" ,"Toggle Durum : $buttonYazi")
            }
            val ulke = binding.aoutoCompleteTextView.text.toString()
            Log.e("Sonuc" ,"Ülke : $ulke")
        }
    }
}