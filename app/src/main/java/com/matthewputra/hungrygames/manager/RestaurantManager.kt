package com.matthewputra.hungrygames.manager

import com.matthewputra.hungrygames.model.Restaurant
import kotlin.random.Random

class RestaurantManager {

    // DUMMY DATA
    private var restaurantList = listOf(
        Restaurant("Red Pepper", 1),
        Restaurant("Thai Tom", 2),
        Restaurant("Mc Donald", 3),
        Restaurant("KFC", 4),
        Restaurant("Taco Bell", 5),
        Restaurant("Wendy's", 6),
        Restaurant("Sushi Place", 7),
        Restaurant("Jack in the Box", 8),
        Restaurant("Just Burger", 9),
        Restaurant("Kusushi", 10),
        Restaurant("Tereyaki 1st", 11),
        Restaurant("Morsel", 12),
        Restaurant("Arepa", 13),
        Restaurant("Aladdins", 14),
        Restaurant("Chipotle", 15),
        Restaurant("Motosurf", 16)
    )

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

    // Delete restaurant from the restaurant list
    fun deleteRestaurant(restaurant: Restaurant) {
        val mutableRestaurant = restaurantList.toMutableList()
        mutableRestaurant.remove(restaurant)
        restaurantList = mutableRestaurant.toList()
    }

}