package com.example.kotlin_practice_recyclerview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_practice_recyclerview.databinding.ActivityMainBinding
import com.example.kotlin_practice_recyclerview.fragment.MainFragment


class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //FirstFragment 띄우기
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, MainFragment())
            commit()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_tool_bar,menu)
        return true
    }


}