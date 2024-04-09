package com.example.kotlin_practice_recyclerview

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin_practice_recyclerview.adapter.DonutAdapter
import com.example.kotlin_practice_recyclerview.databinding.ActivityMainBinding
import com.example.standard_base2.data.Donut
import com.example.standard_base2.data.donutList

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: DonutAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.recyclerView.adapter = DonutAdapter(donutList())

        val adapter = DonutAdapter(donutList())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this,2)

        adapter.itemClick = object : DonutAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                Toast.makeText(this@MainActivity, donutList()[position].name,Toast.LENGTH_SHORT).show()
            }
        }



    }
}