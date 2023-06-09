package com.example.deliveryfood.api

import com.example.deliveryfood.data.ResponseCuisine
import com.example.deliveryfood.data.ResponseDishes
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET

interface Api {
    @GET("058729bd-1402-4578-88de-265481fd7d54")
    fun getJsonCuisine(): Flowable<ResponseCuisine>

    @GET("c7a508f2-a904-498a-8539-09d96785446e")
    fun getJsonDishes(): Flowable<ResponseDishes>
}