package com.matthewputra.hungrygames.model

import android.app.Application
import com.matthewputra.hungrygames.manager.ApiManager
import com.matthewputra.hungrygames.manager.RestaurantManager
import com.matthewputra.hungrygames.manager.UserManager

class HungryGamesApp: Application() {

    lateinit var apiManager: ApiManager
    lateinit var restaurantManager:RestaurantManager
    lateinit var userManager: UserManager

    override fun onCreate() {
        super.onCreate()

        apiManager = ApiManager(this)
        restaurantManager = RestaurantManager()
        userManager = UserManager()
    }
}