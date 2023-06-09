package com.example.deliveryfood.repository

import com.example.deliveryfood.api.Api
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(val api: Api) {
    fun getCuisines() = api.getJsonCuisine()
    fun getDishes() = api.getJsonDishes()
}