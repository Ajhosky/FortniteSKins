package com.example.cats

import Adapter1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cats.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val names: List<String> = listOf("J Balvin.Png","Kuno", "Polar Peely", "Potassius Peel", "Ramirez Redux", "Shady Doggo", "Surf Witch")
        val names: List<String> = listOf("J Balvin.Png","Kuno", "Polar Peely", "Potassius Peel", "Ramirez Redux", "Shady Doggo", "Surf Witch")
        Adapter1(R.drawable.Kuno,   )
    }
}