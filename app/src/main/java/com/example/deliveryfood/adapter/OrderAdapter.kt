package com.example.deliveryfood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryfood.data.OrderItem
import com.example.deliveryfood.databinding.ItemOrderLayoutBinding
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

                var couter = order.count
                buttonPlus.setOnClickListener {
                    couter++
                    counterDishes.text = couter.toString()
                }

                buttonMinus.setOnClickListener {
                    couter--
                    counterDishes.text = couter.toString()
                    if (couter == 0) {
                        val actualPosition = holder.bindingAdapterPosition
                        listOrder.removeAt(actualPosition)
                        notifyItemRemoved(actualPosition)
                        notifyItemRangeChanged(actualPosition, listOrder.size)
                    }
                }
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