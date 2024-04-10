package com.example.kotlin_practice_recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_practice_recyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //FirstFragment 띄우기
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, FirstFragment())
            commit()
        }

    }

}