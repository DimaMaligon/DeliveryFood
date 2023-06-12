package com.example.deliveryfood.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DishItem(
    @SerializedName("description")
    @Expose
    var description: String,
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("image_url")
    @Expose
    var imageUrl: String,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("price")
    @Expose
    var price: Int,
    @SerializedName("tegs")
    @Expose
    var tegs: List<String>,
    @SerializedName("weight")
    @Expose
    var weight: Int
)