package com.matthewputra.hungrygames.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.matthewputra.hungrygames.R
import com.matthewputra.hungrygames.controller.RestaurantListAdapter
import kotlinx.android.synthetic.main.restaurant_list.*

class RestaurantListFragment: Fragment() {

    private lateinit var restaurantListAdapter: RestaurantListAdapter
    private var restaurantList = listOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Dummy data
        restaurantList = listOf("Thai Tom", "KFC", "Red Pepper", "Husky Den", "McDonald", "Bugis",
            "The Alley", "Tasty Pot", "Korean Tofu House", "Chi Mac", "Din Tai Fung", "U:Don", "Capsule Cafe",
            "Bok a Bok", "Alladin", "HUB", "Thai Tom", "KFC", "Red Pepper", "Husky Den", "McDonald", "Bugis",
            "The Alley", "Tasty Pot", "Korean Tofu House", "Chi Mac", "Din Tai Fung", "U:Don", "Capsule Cafe",
            "Bok a Bok", "Alladin", "HUB")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.restaurant_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        restaurantListAdapter =
            RestaurantListAdapter(
                restaurantList
            )
        rvRestaurant.adapter = restaurantListAdapter
    }

}