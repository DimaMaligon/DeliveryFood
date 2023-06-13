package com.example.deliveryfood.fragment_popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.deliveryfood.data.OrderItem
import com.example.deliveryfood.databinding.FragmentPopUpOrderBinding
import com.example.deliveryfood.view.DishViewModel
import com.example.deliveryfood.view.OrderViewModel
import com.squareup.picasso.Picasso


class PopUpOrderFragment : DialogFragment() {
    private lateinit var binding: FragmentPopUpOrderBinding
    private val categoryModel: DishViewModel by activityViewModels()
    private val orderModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopUpOrderBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val dishChosen = categoryModel.dishChosen.value
            Picasso.get().load(dishChosen.imageUrl)
                .into(imagePopupDish)
            titlePopup.text = dishChosen.name
            pricePopup.text = "${dishChosen.price} ₽"
            weightPopup.text = "${dishChosen.weight}г"
            descriptionPopup.text = dishChosen.description

            buttonCancel.setOnClickListener {
                dismiss()
            }

            addBusketPopup.setOnClickListener {
                orderModel.addOrderedDish(OrderItem(dishChosen, 1))
            }
        }
    }
}