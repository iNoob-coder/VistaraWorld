package com.example.vistaraworld.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vistaraworld.Model.CategoryData
import com.example.vistaraworld.databinding.RvPlayCategoryBinding

class CategoryAdapter(private val categoryList: List<CategoryData>, private val listener: CategoryClicked):
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    interface CategoryClicked {
        fun onCategoryClicked(categoryName: String)
    }

    class ViewHolder(val binding: RvPlayCategoryBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RvPlayCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = categoryList[position]

        holder.binding.categoryName.apply {

            //set title
            text = data.categoryName

            //handle click listener
            setOnClickListener {
                listener.onCategoryClicked(data.categoryName)
            }
        }
    }


}