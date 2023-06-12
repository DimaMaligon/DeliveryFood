package com.example.deliveryfood.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CuisineItem(
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("image_url")
    @Expose
    var imageUrl: String,
    @SerializedName("name")
    @Expose
    var name: String
)