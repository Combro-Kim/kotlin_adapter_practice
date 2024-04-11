package com.example.kotlin_practice_recyclerview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_practice_recyclerview.R
import com.example.kotlin_practice_recyclerview.databinding.FragmentDetailBinding
import com.example.standard_base2.data.Donut


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable("selectedDonut", Donut::class.java)?.let {
            inputEachData(it)
        }


    }

    private fun inputEachData(donut: Donut) {
        binding.apply {
            ivDetailDonutImage.setImageResource(donut.image)
            tvDetailDonutName.text = donut.name
            tvDetailDonutPrice.text = donut.price
            tvDetailDonutDescription.text = donut.description
        }
    }

}