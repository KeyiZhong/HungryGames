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

    fun addRestaurant(restaurant: Restaurant){
        //TODO:add restaurant with weight 1 if not exist, add weight otherwise
    }

}