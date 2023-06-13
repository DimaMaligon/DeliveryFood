package com.example.deliveryfood.view

import androidx.lifecycle.ViewModel
import com.example.deliveryfood.data.OrderItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OrderViewModel : ViewModel() {
    private val setOrderedDishesMutable: MutableStateFlow<Set<OrderItem>> =
        MutableStateFlow(mutableSetOf())
    var setOrderedDishes: StateFlow<Set<OrderItem>> = setOrderedDishesMutable

    fun addOrderedDish(item: OrderItem) {
        var newSet = setOrderedDishesMutable.value.plus(item)
        setOrderedDishesMutable.value = newSet
    }
}