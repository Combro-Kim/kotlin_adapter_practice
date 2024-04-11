package com.example.kotlin_practice_recyclerview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin_practice_recyclerview.R
import com.example.kotlin_practice_recyclerview.adapter.DonutAdapter
import com.example.kotlin_practice_recyclerview.data.donutList
import com.example.kotlin_practice_recyclerview.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var binding : FragmentMainBinding
    private lateinit var adapter : DonutAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DonutAdapter(donutList())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(),2)

        adapter.itemClick = object : DonutAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val selectedDonut = adapter.donut[position]
                val detailFragment = DetailFragment().apply {
                    arguments = Bundle().apply {
                        putParcelable("selectedDonut",selectedDonut)
                    }
                }
                requireActivity().supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainer,detailFragment)
                    addToBackStack(null)
                    commit()
                }
            }
        }
    }


}