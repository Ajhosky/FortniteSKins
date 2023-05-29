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
        val skins: List<Int> = listOf(R.drawable.kuno, R.drawable.polar_peely, R.drawable.potassius_peel, R.drawable.shady_doggo, R.drawable.ramirez_redux, R.drawable.surf_witch);
        val textViewNames: List<String> = listOf("kuno", "polar peely", "potassius peel", "shady doggo", "ramirez redux", "surf witch");
        val skinImage: ArrayList<Int> = ArrayList()
        val skinName: ArrayList<String> = ArrayList()
        val btn6Images: ArrayList<Int> = ArrayList()
        val btn6Names: ArrayList<String> = ArrayList()
        var randomInt = 0;
        var myAdapter = Adapter1(skinImage, skinName)
        binding.recyclerCats.layoutManager = GridLayoutManager(binding.recyclerCats.context, 1, RecyclerView.VERTICAL, false)
        binding.btn1.setOnClickListener(){
            btn6Images.clear()
            btn6Names.clear()
            btn6Images.addAll(skinImage)
            btn6Names.addAll(skinName)

            randomInt  = Random.nextInt(0,5)
            skinImage.add(skins[randomInt])
            skinName.add(textViewNames[randomInt])

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
            btn6Images.clear()
            btn6Names.clear()
            btn6Images.addAll(skinImage)
            btn6Names.addAll(skinName)

            skinImage.clear()
            skinName.clear()

            binding.recyclerCats.adapter = myAdapter

        }
        binding.btn3.setOnClickListener(){
            btn6Images.clear()
            btn6Names.clear()
            btn6Images.addAll(skinImage)
            btn6Names.addAll(skinName)
            if (skinImage.size > 0){
                skinImage.removeAt(0)
                skinName.removeAt(0)
                binding.recyclerCats.adapter = myAdapter
            }

        }

        binding.btn4.setOnClickListener(){
            btn6Images.clear()
            btn6Names.clear()
            btn6Images.addAll(skinImage)
            btn6Names.addAll(skinName)
            if (skinImage.size > 0) {
                skinImage.removeAt(skinImage.size - 1)
                skinName.removeAt(skinImage.size - 1)
                binding.recyclerCats.adapter = myAdapter
            }

        }

        binding.btn5.setOnClickListener(){
            btn6Images.clear()
            btn6Names.clear()
            btn6Images.addAll(skinImage)
            btn6Names.addAll(skinName)
            if (skinImage.size > 0) {
                randomInt = Random.nextInt(0,skinImage.size)
                skinImage.removeAt(randomInt)
                skinName.removeAt(randomInt)
                binding.recyclerCats.adapter = myAdapter
            }
        }

        binding.btn6.setOnClickListener(){
            skinImage.clear()
            skinName.clear()
            skinName.addAll(btn6Names)
            skinImage.addAll(btn6Images)
            binding.recyclerCats.adapter = myAdapter
        }


    }
}