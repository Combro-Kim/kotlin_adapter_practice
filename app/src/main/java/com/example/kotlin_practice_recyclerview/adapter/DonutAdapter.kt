package com.example.kotlin_practice_recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_practice_recyclerview.databinding.ItemDonutBinding
import com.example.standard_base2.data.Donut

class DonutAdapter(val donut: MutableList<Donut>) : RecyclerView.Adapter<DonutAdapter.Holder>() {

    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemDonutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.image.setImageResource(donut[position].image)
        holder.name.text = donut[position].name
        holder.price.text = donut[position].price
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return donut.size
    }

    inner class Holder(private val binding: ItemDonutBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.donutImageView
        val name = binding.donutNameTextView
        val price = binding.donutPriceTextView
    }
}