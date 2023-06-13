package com.example.deliveryfood.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryfood.PopUpOrderFragment
import com.example.deliveryfood.data.DishItem
import com.example.deliveryfood.data.OrderItem
import com.example.deliveryfood.databinding.ItemDishLayoutBinding
import com.example.deliveryfood.databinding.ItemOrderLayoutBinding
import com.example.deliveryfood.view.DishViewModel
import com.squareup.picasso.Picasso


class OrderAdapter : RecyclerView.Adapter<OrderAdapter.OrderHolder>() {
    private var listOrder = mutableListOf<OrderItem>()

    inner class OrderHolder(val binding: ItemOrderLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder {
        val binding =
            ItemOrderLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderHolder, position: Int) {
        with(holder) {
            val order = listOrder[position]
            binding.apply {
                titleOrder.text = order.dishItem.name
                priceOrder.text = order.dishItem.price.toString()
                weghtOrder.text = order.dishItem.weight.toString()
                    Picasso.get().load(order.dishItem.imageUrl)
                        .into(imageOrder).toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return listOrder.size
    }

    fun setDishList(list: List<OrderItem>) {
        listOrder = list.toMutableList()
        notifyDataSetChanged()
    }
}