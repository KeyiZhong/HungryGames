package com.matthewputra.hungrygames.manager

import com.matthewputra.hungrygames.model.Restaurant
import kotlin.random.Random

class RestaurantManager {
    private lateinit var restaurantList:List<Restaurant>
    // TODO: INSERT DUMMY DATA

    fun getList():List<Restaurant>{
        return restaurantList
    }

    fun getRandomChoice():Restaurant{
        //TODO:get random choice based on current list
        var weightSum = 0
        for (restaurant in restaurantList) {
            weightSum += restaurant.weight
        }
        var randomChoice = Random.nextInt(weightSum)
        for (restaurant in restaurantList) {
            randomChoice -= restaurant.weight
            if(randomChoice <= 0) {
                return restaurant
            }
        }
        return restaurantList[restaurantList.size - 1]
    }

    fun getChoice(): Restaurant {
        //TODO: get choice with the highest vote
        return restaurantList[0]
    }

    // Add given restaurant to the restaurant list
    fun addRestaurant(restaurant: Restaurant){
        val mutableRestaurant = restaurantList.toMutableList()
        mutableRestaurant.add(restaurant)
        restaurantList = mutableRestaurant.toList()
    }

}