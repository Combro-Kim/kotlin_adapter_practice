package com.example.kotlin_practice_recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_practice_recyclerview.databinding.FragmentDonutListBinding
import com.example.standard_base2.data.Donut
import com.example.standard_base2.data.donutList
import kotlin.random.Random
import kotlin.random.nextInt

class DonutListFragment:Fragment(R.layout.fragment_donut_list) {
    private lateinit var binding: FragmentDonutListBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun setDatatoDetail(){
//        val randomNum = Random.nextInt(0..6)
        binding.button1.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("data1", "데이터1")
            val receiverFragment = ReceiverFragment

        }
    }

}