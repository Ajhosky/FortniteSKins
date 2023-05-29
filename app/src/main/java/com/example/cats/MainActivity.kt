package com.example.cats

import Adapter1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cats.databinding.ActivityMainBinding
import kotlin.math.log
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val skins: List<Int> = listOf(R.drawable.kuno, R.drawable.polar_peely, R.drawable.potassius_peel, R.drawable.shady_doggo, R.drawable.ramirez_redux, R.drawable.surf_witch);
        val textViewNames: List<String> = listOf("kuno", "polar peely", "potassius peel", "shady doggo", "ramirez redux", "surf witch");
        val names: ArrayList<Int> = ArrayList()
        val btn6names: ArrayList<Int> = ArrayList()
        var randomInt = 0;
        var myAdapter = Adapter1(names, textViewNames)
        binding.recyclerCats.layoutManager = GridLayoutManager(binding.recyclerCats.context, 1, RecyclerView.VERTICAL, false)
        binding.btn1.setOnClickListener(){
            btn6names.clear()
            btn6names.addAll(names)

            randomInt  = Random.nextInt(0,5)
            names.add(skins[randomInt])

            binding.recyclerCats.adapter = myAdapter
        }
        binding.ColumnInput.addTextChangedListener{
            var cols = binding.ColumnInput.text.toString()
            if(cols == ""){
                cols = "1"
            }
            binding.recyclerCats.layoutManager = GridLayoutManager(binding.recyclerCats.context, cols.toInt(), RecyclerView.VERTICAL, false)
        }
        binding.btn2.setOnClickListener(){
            btn6names.clear()
            btn6names.addAll(names)
            names.clear()

            binding.recyclerCats.adapter = myAdapter

        }
        binding.btn3.setOnClickListener(){
            btn6names.clear()
            btn6names.addAll(names)
            if (names.size > 0){
                names.removeAt(0)
                binding.recyclerCats.adapter = myAdapter
            }

        }

        binding.btn4.setOnClickListener(){
            btn6names.clear()
            btn6names.addAll(names)
            if (names.size > 0) {
                names.removeAt(names.size - 1)

                binding.recyclerCats.adapter = myAdapter
            }

        }

        binding.btn5.setOnClickListener(){
            btn6names.clear()
            btn6names.addAll(names)
            if (names.size > 0) {
                randomInt = Random.nextInt()
                names.removeAt(randomInt)

                binding.recyclerCats.adapter = myAdapter
            }
        }

        binding.btn6.setOnClickListener(){
            names.clear()
            names.addAll(btn6names)
            binding.recyclerCats.adapter = myAdapter
        }


    }
}