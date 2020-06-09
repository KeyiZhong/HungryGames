package com.matthewputra.hungrygames.manager

import com.matthewputra.hungrygames.model.Restaurant

class RestaurantManager {
    lateinit var restaurantList:List<Restaurant>

    fun getList():List<Restaurant>{
        return restaurantList
    }

    fun getRandomChoice():Restaurant{
        //TODO:get random choice based on current list
        val weightSum = 0
        for (restaurant in restaurantList) {
            weightSum += restaurant.weight
        }
        val randomChoice = java.util.Random.nextInt(weightSum)
        for (restaurant in restaurantList) {
            randomChoice -= restaurant.weight
            if(randomChoice <= 0) {
                return restaurant
            }
        }
        return restaurantList[restaurantList.size - 1]
    }

    // Add given restaurant to the restaurant list
    fun addRestaurant(restaurant: Restaurant){
        val mutableRestaurant = restaurantList.toMutableList()
        mutableRestaurant.add(restaurant)
        restaurantList = mutableRestaurant.toList()
    }

}