package com.matthewputra.hungrygames.fragments

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.matthewputra.hungrygames.R
import com.matthewputra.hungrygames.activity.RestaurantApp
import com.matthewputra.hungrygames.model.Restaurant
import kotlinx.android.synthetic.main.add_restaurant.*

class AddRestaurantFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.add_restaurant, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.let {
            initAdd(it)
        }
    }

    private fun initAdd(context: Context) {
        // Add button click
        btnAdd.setOnClickListener {
            val restaurant = Restaurant("", 1)
            // Check whether name is null or not
            if (etAddName.text == null) {
                Toast.makeText(context, "Please enter a restaurant name", Toast.LENGTH_SHORT).show()
            } else {
                restaurant.name = etAddName.text.toString()
                // Check whether weight is null or not
                if (etAddWeight.text == null) {
                    restaurant.weight = 1
                } else {
                    restaurant.weight = etAddWeight.text.toString().toInt()
                }
                (context as RestaurantApp).restaurantManager.addRestaurant(restaurant)
            }
        }
    }
}