package com.example.deliveryfood.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseDishes(
    @SerializedName("dishes")
    @Expose
    var dishes: List<DishItem>
)