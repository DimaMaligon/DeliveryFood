package com.example.deliveryfood.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryfood.R
import com.example.deliveryfood.data.CuisineItem
import com.example.deliveryfood.databinding.ItemCuisineLayoutBinding
import com.squareup.picasso.Picasso


class CuisineAdapter constructor(private val fragment: Fragment) :
    RecyclerView.Adapter<CuisineAdapter.CuisineHolder>() {
    private var listCuisines = mutableListOf<CuisineItem>()

    inner class CuisineHolder(val binding: ItemCuisineLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuisineHolder {
        val binding =
            ItemCuisineLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CuisineHolder(binding)
    }

    override fun onBindViewHolder(holder: CuisineHolder, position: Int) {
        with(holder) {
            val cuisine = listCuisines[position]
            binding.apply {
                textCuisine.text = cuisine.name
                Picasso.get().load(cuisine.imageUrl)
                    .into(imageCuisine)
                imageCuisine.setOnClickListener {
                    findNavController(fragment).navigate(R.id.action_mainFragment_to_categoryFragment)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listCuisines.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCuisineList(listCuisines: ArrayList<CuisineItem>) {
        this.listCuisines = listCuisines.toMutableList()
        notifyDataSetChanged()
    }

}