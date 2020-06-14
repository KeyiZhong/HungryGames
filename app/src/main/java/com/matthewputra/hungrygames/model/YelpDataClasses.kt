package com.matthewputra.hungrygames.model

import com.google.gson.annotations.SerializedName

data class YelpSearchResults (
    @SerializedName("total") val total: Int,
    @SerializedName("businesses") val restaurants: List<YelpRestaurant>
)

data class YelpRestaurant (
    val name: String,
    val rating: Double,
    val price: String,
    @SerializedName("review_count") val reviews: Int,
    @SerializedName("distance") val distanceInMeters: Double,
    @SerializedName("image_url") val imageUrl: String,
    val categories: List<YelpCategory>,
    val location: YelpLocation
) {
    fun displayDistance(): String {
        return "$distanceInMeters m"
    }
}

data class YelpCategory (
    val title: String
)

data class YelpLocation(
    @SerializedName("address1") val address: String
)