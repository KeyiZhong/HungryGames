package com.matthewputra.hungrygames.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.matthewputra.hungrygames.R
import com.matthewputra.hungrygames.activity.RestaurantApp
import com.matthewputra.hungrygames.controller.RestaurantListAdapter
import com.matthewputra.hungrygames.model.Restaurant
import kotlinx.android.synthetic.main.restaurant_list.*

class RestaurantListFragment: Fragment() {

    private lateinit var restaurantListAdapter: RestaurantListAdapter
    private lateinit var restaurantList: List<Restaurant>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

        restaurantList = (context as RestaurantApp).restaurantManager.getList()

        restaurantListAdapter =
            RestaurantListAdapter(
                restaurantList
            )
        rvRestaurant.adapter = restaurantListAdapter
    }

}