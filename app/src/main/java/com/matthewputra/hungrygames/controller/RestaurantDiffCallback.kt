package com.matthewputra.hungrygames.controller

import androidx.recyclerview.widget.DiffUtil

// TODO: Change this to type Restaurant
class RestaurantDiffCallback(
    private val oldRestaurant: List<String>,
    private val newRestaurant: List<String>
): DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldRestaurant = this.oldRestaurant[oldItemPosition]
        val newRestaurant = this.newRestaurant[newItemPosition]

        return oldRestaurant == newRestaurant
    }

    override fun getOldListSize(): Int = oldRestaurant.size

    override fun getNewListSize(): Int = newRestaurant.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldRestaurant = this.oldRestaurant[oldItemPosition]
        val newRestaurant = this.newRestaurant[newItemPosition]

        return oldRestaurant == newRestaurant
    }
}