package com.example.deliveryfood.fragment_actionbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.deliveryfood.R

class ActionBarFullFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_action_bar_full, container, false)
    }

    companion object {
        fun newInstance() = ActionBarFullFragment()
    }
}