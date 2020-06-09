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
        val chosenRestaurantList = mutableListOf<Restaurant>()
        if (restaurantList.size != 0) {
            chosenRestaurantList.add(restaurantList[0])
            for (restaurant in restaurantList) {
                if (chosenRestaurantList[0].weight < restaurant.weight) {
                    chosenRestaurantList.clear()
                    chosenRestaurantList.add(restaurant)
                } else if (chosenRestaurantList[0].weight == restaurant.weight) {
                    chosenRestaurantList.add(restaurant)
                }
            }
        }

        if (chosenRestaurantList.size != 0) {
            return chosenRestaurantList[Random.nextInt(chosenRestaurantList.size)]
        } else {
            return Restaurant("No data", -1)
        }
    }

    // Add given restaurant to the restaurant list
    fun addRestaurant(restaurant: Restaurant){
        val mutableRestaurant = restaurantList.toMutableList()
        mutableRestaurant.add(restaurant)
        restaurantList = mutableRestaurant.toList()
    }

}