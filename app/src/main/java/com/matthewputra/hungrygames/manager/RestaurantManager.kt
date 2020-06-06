package com.matthewputra.hungrygames.manager

import com.matthewputra.hungrygames.model.Restaurant

class RestaurantManager {
    lateinit var restaurantList:List<Restaurant>

    fun getList():List<Restaurant>{
        return restaurantList
    }

    fun getRandomChoice():Restaurant{
        //TODO:get random choice based on current list
    }

    // Add given restaurant to the restaurant list
    fun addRestaurant(restaurant: Restaurant){
        val mutableRestaurant = restaurantList.toMutableList()
        mutableRestaurant.add(restaurant)
        restaurantList = mutableRestaurant.toList()
    }

}