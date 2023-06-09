package com.example.deliveryfood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryfood.adapter.CuisineAdapter
import com.example.deliveryfood.data.CuisineItem
import com.example.deliveryfood.databinding.FragmentMainBinding
import com.example.deliveryfood.view.CuisineViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val cuisineModel: CuisineViewModel by activityViewModels()
    private val adapter = CuisineAdapter(this)
    private lateinit var listCurrentCuisines: ArrayList<CuisineItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cuisineModel.getCuisines()
        listCurrentCuisines = cuisineModel.listCuisines.value as ArrayList<CuisineItem>
        setListRecycler(listCurrentCuisines)
    }

    private fun setListRecycler(listCuisines: ArrayList<CuisineItem>) {
        binding.apply {
            val linerManager = LinearLayoutManager(activity)
            recyclerCuisine.layoutManager = linerManager
            recyclerCuisine.adapter = adapter
            adapter.setCuisineList(listCuisines)
        }
    }
}