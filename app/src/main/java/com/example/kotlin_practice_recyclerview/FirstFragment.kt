package com.example.kotlin_practice_recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_practice_recyclerview.databinding.FragmentFirstBinding

private const val ARG_PARAM1 = "param1"


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root

        // 버튼 클릭 시 값을 전달하고 다음 Fragment로 이동
        binding.button1.setOnClickListener {
            val userId = binding.editTextUserId.text.toString()
            val password = binding.editTextPassword.text.toString()

            val bundle = Bundle().apply {
                putString("userId", userId)
                putString("password", password)
            }

            val fragment2 = SecondFragment().apply {
                arguments = bundle
            }

            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, fragment2)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }
}