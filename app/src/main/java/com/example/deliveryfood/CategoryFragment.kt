package com.example.deliveryfood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryfood.adapter.DishAdapter
import com.example.deliveryfood.adapter.TagAdapter
import com.example.deliveryfood.data.CuisineItem
import com.example.deliveryfood.data.DishItem
import com.example.deliveryfood.databinding.FragmentCategoryBinding
import com.example.deliveryfood.view.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding
    private val categoryModel: CategoryViewModel by activityViewModels()
    private val adapterDish = DishAdapter()
    private lateinit var adapterTag: TagAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryModel.apply {
            initRecyclerTag()
            getDishes()
            observeState()
        }

    }

    private fun initRecyclerDish(listDishes: ArrayList<DishItem>) {
        binding.apply {
            val gridManager = GridLayoutManager(activity, 3)
            recyclerDishes.layoutManager = gridManager
            recyclerDishes.adapter = adapterDish
            adapterDish.setDishList(listDishes)
        }
    }

    private fun initRecyclerTag() {
        binding.apply {
            adapterTag = TagAdapter(categoryModel)
            val linerManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            recyclerTag.layoutManager = linerManager
            recyclerTag.adapter = adapterTag
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            categoryModel.listDishes.collect {
                initRecyclerDish(it as ArrayList<DishItem>)
            }
        }
    }
}