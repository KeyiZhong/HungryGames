package com.matthewputra.hungrygames.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurant(
    var name:String,
    var weight:Int
    // need to add yelp api information
):Parcelable