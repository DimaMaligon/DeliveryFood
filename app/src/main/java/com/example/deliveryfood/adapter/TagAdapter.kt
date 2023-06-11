package com.example.deliveryfood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryfood.R
import com.example.deliveryfood.data.Categories
import com.example.deliveryfood.databinding.TagItemLayoutBinding
import com.example.deliveryfood.view.CategoryViewModel


class TagAdapter(val viewModel: CategoryViewModel) : RecyclerView.Adapter<TagAdapter.TagHolder>() {
    private var listTag = Categories.categories

    inner class TagHolder(val binding: TagItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagHolder {
        val binding =
            TagItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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