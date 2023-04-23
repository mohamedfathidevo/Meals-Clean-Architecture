package com.mohamedfathidev.mealscleanarchitecture

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mohamedfathidev.domain.entity.Meal
import com.mohamedfathidev.mealscleanarchitecture.databinding.CategoryItemBinding

class MealsAdapter() : ListAdapter<Meal, MealsAdapter.ViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val itemBinding: CategoryItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(meal: Meal) {
            itemBinding.categoryNameTv.text = meal.strCategory
            itemBinding.categoryDesTv.text = meal.strCategoryDescription
            Glide.with(itemBinding.root.context).load(meal.strCategoryThumb).into(itemBinding.categoryIv)
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(
            oldItem: Meal,
            newItem: Meal
        ): Boolean {
            return oldItem.idCategory == newItem.idCategory
        }

        override fun areContentsTheSame(
            oldItem: Meal,
            newItem: Meal
        ): Boolean {
            return oldItem == newItem
        }
    }
}