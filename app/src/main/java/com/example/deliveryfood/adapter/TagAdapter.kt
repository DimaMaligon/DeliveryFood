package com.example.deliveryfood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryfood.data.Categories
import com.example.deliveryfood.databinding.ItemTagLayoutBinding
import com.example.deliveryfood.view.DishViewModel


class TagAdapter(val viewModel: DishViewModel) : RecyclerView.Adapter<TagAdapter.TagHolder>() {
    private var listTag = Categories.categories

    inner class TagHolder(val binding: ItemTagLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagHolder {
        val binding =
            ItemTagLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TagHolder(binding)
    }

    override fun onBindViewHolder(holder: TagHolder, position: Int) {
        with(holder) {
            val tag = listTag[position]
            binding.apply {
                tagButton.apply {
                    text = tag
                    setOnClickListener {
                        viewModel.getDishesByTag(tag)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listTag.size
    }
}