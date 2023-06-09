package com.example.deliveryfood.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryfood.fragment_popup.PopUpOrderFragment
import com.example.deliveryfood.data.DishItem
import com.example.deliveryfood.databinding.ItemDishLayoutBinding
import com.example.deliveryfood.view.DishViewModel
import com.squareup.picasso.Picasso


class DishAdapter constructor(private val fragment: Fragment) : RecyclerView.Adapter<DishAdapter.DishHolder>() {
    private var listDish = mutableListOf<DishItem>()
    private val categoryModel: DishViewModel by fragment.activityViewModels()

    inner class DishHolder(val binding: ItemDishLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishHolder {
        val binding =
            ItemDishLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DishHolder(binding)
    }

    override fun onBindViewHolder(holder: DishHolder, position: Int) {
        with(holder) {
            val dish = listDish[position]
            binding.apply {
                titleDish.text = dish.name
                Picasso.get().load(dish.imageUrl)
                    .into(imageDish)
                imageDish.setOnClickListener {
                    categoryModel.setChosenDish(dish)
                    showPopUpDish()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listDish.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDishList(listDishes: ArrayList<DishItem>) {
        listDish = listDishes.toMutableList()
        notifyDataSetChanged()
    }

    fun showPopUpDish(){
        val popup = PopUpOrderFragment()
        popup.show((fragment).parentFragmentManager, "showPopUp")
    }

}