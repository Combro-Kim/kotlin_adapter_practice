package com.example.kotlin_practice_recyclerview

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin_practice_recyclerview.adapter.DonutAdapter
import com.example.kotlin_practice_recyclerview.databinding.ActivityMainBinding
import com.example.standard_base2.data.Donut
import com.example.kotlin_practice_recyclerview.data.donutList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
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

        val adapter = DonutAdapter(donutList())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)

        val intent = Intent(this, DetailActivity::class.java)
        adapter.itemClick = object : DonutAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val selectedData = donutList()[position]
                intent.putExtra("selectedData", selectedData)
                startActivity(intent)

            }
        }
    }
}