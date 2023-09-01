package com.example.vistaraworld.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vistaraworld.Model.SliderData
import com.example.vistaraworld.databinding.SliderLayoutBinding

class SliderAdapter(private val sliderList: List<SliderData>): RecyclerView.Adapter<SliderAdapter.ViewHolder>() {

    class ViewHolder(val binding: SliderLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SliderLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return sliderList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = sliderList[position]

        Glide.with(holder.itemView.context).load(data.image).into(holder.binding.image)
        holder.binding.title.text = data.title
    }


}