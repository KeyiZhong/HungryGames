package com.matthewputra.hungrygames.activity

import android.app.Application
import com.matthewputra.hungrygames.manager.ApiManager
import com.matthewputra.hungrygames.manager.RestaurantManager

class RestaurantApp: Application() {
    lateinit var apiManager:ApiManager

    lateinit var restaurantManager:RestaurantManager

    override fun onCreate() {
        super.onCreate()

        apiManager = ApiManager(this)
        restaurantManager = RestaurantManager()

    }
}