package com.example.deliveryfood.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryfood.R
import com.example.deliveryfood.adapter.OrderAdapter
import com.example.deliveryfood.data.OrderItem
import com.example.deliveryfood.databinding.FragmentBasketBinding
import com.example.deliveryfood.fragment_actionbar.ActionBarFullFragment
import com.example.deliveryfood.view.OrderViewModel

class BasketFragment : Fragment() {
    private lateinit var binding: FragmentBasketBinding
    private val orderModel: OrderViewModel by activityViewModels()
    private val adapterOrder = OrderAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasketBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openFragment(ActionBarFullFragment.newInstance(), R.id.actionbar_basket)
        val listOrders = orderModel.setOrderedDishes.value.toList()
        initRecyclerOrders(listOrders)
    }

    private fun initRecyclerOrders(list: List<OrderItem>) {
        binding.apply {
            val linerManager = LinearLayoutManager(activity)
            recyclerBasket.layoutManager = linerManager
            recyclerBasket.adapter = adapterOrder
            adapterOrder.setDishList(list)
        }
    }

    private fun openFragment(f: Fragment, idHolder: Int) {
        parentFragmentManager.beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}