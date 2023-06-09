package com.example.deliveryfood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryfood.adapter.DishAdapter
import com.example.deliveryfood.data.CuisineItem
import com.example.deliveryfood.data.DishItem
import com.example.deliveryfood.databinding.FragmentCategoryBinding
import com.example.deliveryfood.view.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding
    private val categoryModel: CategoryViewModel by activityViewModels()
    private val adapter = DishAdapter()

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
            getDishes()
            val listCurrentDishes = listDishes.value as ArrayList<DishItem>
            setListRecycler(listCurrentDishes)
        }

    }

    private fun setListRecycler(listDishes: ArrayList<DishItem>) {
        binding.apply {
            val gridManager = GridLayoutManager(activity, 4)
            recyclerDishes.layoutManager = gridManager
            recyclerDishes.adapter = adapter
            adapter.setDishList(listDishes)
        }
    }

}