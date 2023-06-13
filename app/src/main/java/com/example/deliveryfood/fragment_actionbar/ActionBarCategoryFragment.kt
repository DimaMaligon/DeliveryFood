package com.example.deliveryfood.fragment_actionbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.deliveryfood.databinding.FragmentActionBarCategoryBinding

class ActionBarCategoryFragment : Fragment() {
    private lateinit var binding: FragmentActionBarCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentActionBarCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    companion object {
        fun newInstance() = ActionBarCategoryFragment()
    }
}