package com.example.deliveryfood.data

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class ResponseCuisine(
    @SerializedName("сategories")
    @Expose
    var сategories: List<CuisineItem>
)