package com.example.kotlin_practice_recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlin_practice_recyclerview.databinding.ActivityDetailBinding
import com.example.standard_base2.data.Donut

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        edgeToEdge()
        setContentView(binding.root)

        val selectedData = intent.getParcelableExtra("selectedData", Donut::class.java)
        selectedData?.let { eachData(it) }

    }

    private fun eachData(donut: Donut) {
        binding.apply {

            ivDetailDonutImage.setImageResource(donut.image)
            tvDetailDonutName.text = donut.name
            tvDetailDonutPrice.text = donut.price
            tvDetailDonutDescription.text = donut.description
        }


    }


    private fun edgeToEdge() {
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}