package com.matthewputra.hungrygames.manager

import android.content.Context
import android.util.Log
import com.matthewputra.hungrygames.model.YelpSearchResults
import com.matthewputra.hungrygames.model.YelpService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager(context: Context) {

    private lateinit var yelpService: YelpService

    companion object {
        private const val BASE_URL = "https://api.yelp.com/v3/"
        private const val API_KEY = "zySmKMwrxdL73J7He0kxs_WgiUYC18xMkg2IPNb-kSUL-1Fb9SnMHcelkxUveB8FUmwyiwQCOkXJxBANh3sbJg740BiqPhwdV1-8BZEtMxIY1NcjHMeLo3_GyuXYXnYx"
    }

    init {
        createYelpService()
    }

    private fun createYelpService() {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        yelpService = retrofit.create(YelpService::class.java)
    }

    fun searchRestaurants(searchTerm: String, location: String) {
        yelpService.searchRestaurants("Bearer $API_KEY","$searchTerm", "$location").enqueue(object: Callback<YelpSearchResults> {
            override fun onResponse(call: Call<YelpSearchResults>, response: Response<YelpSearchResults>) {
                Log.i("aluu", "$response")
            }

            override fun onFailure(call: Call<YelpSearchResults>, t: Throwable) {
                Log.i("aluu", "$t") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}