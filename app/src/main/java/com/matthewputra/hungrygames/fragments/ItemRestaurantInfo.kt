package com.matthewputra.hungrygames.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.matthewputra.hungrygames.R
import com.matthewputra.hungrygames.model.Restaurant
import kotlinx.android.synthetic.main.item_restaurant_info.*

class ItemRestaurantInfo: Fragment() {

    companion object {
        val TAG: String = RestaurantListFragment::class.java.simpleName
        private lateinit var restaurant: Restaurant

        const val CHOSEN_RESTAURANT = "chosen_restaurant"
        const val INFO_RESTAURANT = "info_restaurant"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getParcelable<Restaurant>(CHOSEN_RESTAURANT)?.let {
            restaurant = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.item_restaurant_info, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvResName.text = restaurant.name
    }

}