package com.matthewputra.hungrygames

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class RestaurantListAdapter(private var listOfRestaurant: List<String>): RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder>() {

    inner class RestaurantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvRestaurantName by lazy { itemView.findViewById<TextView>(R.id.tvRestaurantName) }

        fun bind(restaurant: String) {
            tvRestaurantName.text = restaurant
        }
    }

    fun change(newRestaurant: List<String>) {
        //for animation when list is updated
        val callback = RestaurantDiffCallback(listOfRestaurant, newRestaurant)
        val difResult = DiffUtil.calculateDiff(callback)
        difResult.dispatchUpdatesTo(this)
        listOfRestaurant = newRestaurant
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun getItemCount() = listOfRestaurant.size

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(listOfRestaurant[position])
    }

}