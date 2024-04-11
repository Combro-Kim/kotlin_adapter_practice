package com.example.kotlin_practice_recyclerview.fragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_practice_recyclerview.R
import com.example.kotlin_practice_recyclerview.databinding.DialogCustomBinding
import com.example.kotlin_practice_recyclerview.databinding.FragmentDetailBinding
import com.example.standard_base2.data.Donut
import java.util.Calendar


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
//        val mainToolBar = requireActivity().findViewById<View>(R.id.main_tool_bar)
//        mainToolBar.visibility = View.GONE

        arguments?.getParcelable("selectedDonut", Donut::class.java)?.let {
            inputEachData(it)
        }

        binding.btn1Alert.setOnClickListener {
            dialogBase()
        }

        binding.btn2Custom.setOnClickListener {
            dialogCustom()
        }
        binding.btn3Date.setOnClickListener {
            dialogDatePicker()
        }
        binding.btn4Time.setOnClickListener {
            dialogTimePicker()
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


    private fun dialogBase() {
        val alertDialog = AlertDialog.Builder(requireContext())
            .setTitle("권한")
            .setMessage("권한을 허용하시겠습니까?")
            .setPositiveButton("허용") { dialog, _ ->
                dialog.dismiss()
            }
            .setNegativeButton("거부") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
        alertDialog.show()
    }

    private fun dialogCustom() {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_custom, null)
        val dialogBinding = DialogCustomBinding.bind(dialogView)

        builder.setView(dialogView)
            .setPositiveButton("저장") { _, _ ->
                val name = dialogBinding.editText.text.toString()
                val nickname = dialogBinding.editText2.text.toString()

                Toast.makeText(requireContext(), "$name $nickname", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("취소") { _, _ ->
            }
            .create()
            .show()
    }

    private fun dialogDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DATE)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, myYear, myMonth, myDay ->
            val selectedDate = "$myYear-${myMonth + 1}-$myDay"
            Toast.makeText(requireContext(), selectedDate, Toast.LENGTH_SHORT).show()

        }, year, month, day)
        datePickerDialog.show()
    }

    private fun dialogTimePicker() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            requireContext(), { _, myHour, myMinute ->
                val selectedTime = "$myHour : $myMinute"
                Toast.makeText(requireContext(), selectedTime, Toast.LENGTH_SHORT).show()
            }, hour, minute, true
        )
        timePickerDialog.show()
    }

/*    override fun onDestroyView() {
        super.onDestroyView()
        val mainToolBar = requireActivity().findViewById<View>(R.id.main_tool_bar)
        mainToolBar.visibility = View.VISIBLE
    }*/
}
