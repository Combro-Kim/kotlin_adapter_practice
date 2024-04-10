package com.example.kotlin_practice_recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_practice_recyclerview.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root

        // Bundle에서 데이터 추출
        val bundle = arguments
        val userId = bundle?.getString("userId")
        val password = bundle?.getString("password")

        // 받아온 데이터를 화면에 표시
        binding.textViewUserId.text = userId
        binding.textViewPassword.text = password

        return view
    }
}
