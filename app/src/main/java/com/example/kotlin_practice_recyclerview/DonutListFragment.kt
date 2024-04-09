package com.example.kotlin_practice_recyclerview


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_practice_recyclerview.adapter.DonutAdapter
import com.example.kotlin_practice_recyclerview.databinding.FragmentDonutListBinding



class DonutListFragment : Fragment(R.layout.fragment_donut_list) {
    private lateinit var binding: FragmentDonutListBinding
    private lateinit var donutAdapter: DonutAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDonutListBinding.inflate(inflater)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}