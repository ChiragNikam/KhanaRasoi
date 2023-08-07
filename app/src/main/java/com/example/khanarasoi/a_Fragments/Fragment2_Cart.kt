package com.example.khanarasoi.a_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.khanarasoi.R
import com.example.khanarasoi.b_Adapter.Adapter1_FoodItems
import com.example.khanarasoi.b_Adapter.Adapter2_CartItems
import com.example.khanarasoi.c_Class.Class0_FoodItemsInfo
import com.example.khanarasoi.databinding.Fragment1HomeBinding
import com.example.khanarasoi.databinding.Fragment2CartBinding

class Fragment2_Cart : Fragment() {
    private val binding: Fragment2CartBinding by lazy {
        Fragment2CartBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Add image to Array List (of type SlideModel) by image links
        val cart_items = Adapter1_FoodItems().lst_cart
        val adapter = Adapter2_CartItems(cart_items)
        binding.recyclerCartItems.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerCartItems.adapter = adapter
    }
}