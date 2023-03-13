package com.example.cats

import Adapter1
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cats.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //val names: List<String> = listOf("J Balvin.Png","Kuno", "Polar Peely", "Potassius Peel", "Ramirez Redux", "Shady Doggo", "Surf Witch")
        //val names: List<String> = listOf("J Balvin.Png","Kuno", "Polar Peely", "Potassius Peel", "Ramirez Redux", "Shady Doggo", "Surf Witch")
        val skins: List<Int> = listOf(R.drawable.kuno, R.drawable.polar_peely, R.drawable.potassius_peel, R.drawable.shady_doggo, R.drawable.ramirez_redux, R.drawable.surf_witch);
        val names: ArrayList<Int> = ArrayList()
        var randomInt = 0;
        var myAdapter = Adapter1(names)
        binding.recyclerCats.layoutManager = GridLayoutManager(binding.recyclerCats.context, 1, RecyclerView.VERTICAL, false)
        binding.btn1.setOnClickListener(){
            randomInt  = Random.nextInt(0,5)
            names.add(skins[randomInt])

            binding.recyclerCats.adapter = myAdapter
        }
        binding.ColumnInput.addTextChangedListener{
            var cols = binding.ColumnInput.text.toString().toInt()
            if(cols.toString()==""){
                cols = 1
            }
            binding.recyclerCats.layoutManager = GridLayoutManager(binding.recyclerCats.context, cols, RecyclerView.VERTICAL, false)
        }
        binding.btn2.setOnClickListener(){
            names.clear()
            binding.recyclerCats.adapter = myAdapter
        }
        binding.btn3.setOnClickListener(){

        }

        binding.btn4.setOnClickListener(){

        }

        binding.btn5.setOnClickListener(){

        }

        binding.btn6.setOnClickListener(){

        }


    }
}