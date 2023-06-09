package com.example.deliveryfood.app

import android.app.Application
import com.example.deliveryfood.adapter.CuisineAdapter
import com.example.deliveryfood.repository.Repository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {
    @Inject
    lateinit var repository: Repository

    override fun onCreate() {
        super.onCreate()
    }
}