package com.example.kotlin_practice_recyclerview.fragment

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlin_practice_recyclerview.R
import com.example.kotlin_practice_recyclerview.adapter.DonutAdapter
import com.example.kotlin_practice_recyclerview.data.donutList
import com.example.kotlin_practice_recyclerview.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var notificationManager: NotificationManager
    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter : DonutAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        (requireActivity() as AppCompatActivity).supportActionBar?.show()
//        (requireActivity() as AppCompatActivity).findViewById<Toolbar>(R.id.main_tool_bar)?.show()

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

        setUpNotification()
        binding.titleTextView.setOnClickListener{
            showNotification()
        }

    }

    private fun setUpNotification(){
        notificationManager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            val channelId = "id"
            val channelName = "name"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId,channelName,importance).apply {
                description = "description"
                enableLights(true)
                lightColor = Color.RED
            }
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification() {
        val channelId = "your_channel_id"
        val notificationId = 1

        // Create notification intent (you can specify activity or broadcast receiver)
        val intent = Intent(requireContext(), MainFragment::class.java)
        val pendingIntent = PendingIntent.getActivity(requireContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        // Build notification
        val notification = NotificationCompat.Builder(requireContext(), channelId)
            .setSmallIcon(R.drawable.icon_notification) // Set your notification icon
            .setContentTitle("Your Notification Title")
            .setContentText("Your Notification Text")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true) // Remove the notification from the notification drawer when clicked
            .build()

        // Display the notification
        notificationManager.notify(notificationId, notification)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}