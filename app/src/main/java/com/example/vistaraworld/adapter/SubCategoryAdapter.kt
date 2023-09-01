package com.example.vistaraworld.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vistaraworld.databinding.RvSubCategoryItemBinding

class SubCategoryAdapter(private val subCategoryList: List<String>): RecyclerView.Adapter<SubCategoryAdapter.ViewHolder>() {
    class ViewHolder(val binding: RvSubCategoryItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RvSubCategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return subCategoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = subCategoryList[position]

        //set image using glide library
        Glide.with(holder.itemView.context).load(data).into(holder.binding.thumbnail)
    }


}