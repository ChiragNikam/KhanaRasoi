package com.example.khanarasoi.a_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khanarasoi.b_Adapter.Adapter2_CartItems
import com.example.khanarasoi.c_Class.Class1_CartItemsInfo
import com.example.khanarasoi.databinding.Fragment2CartBinding

class Fragment2_Cart : Fragment() {
    private val binding: Fragment2CartBinding by lazy {
        Fragment2CartBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Add image to Array List (of type SlideModel) by image links
        val cart_item1 = Class1_CartItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600",
            1
        )
        val cart_item2 = Class1_CartItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600",
            1
        )
        val cart_item3 = Class1_CartItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600",
            1
        )
        val cart_item4 = Class1_CartItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600",
            1
        )
        val cart_item5 = Class1_CartItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600",
            1
        )
        val cart_item6 = Class1_CartItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600",
            1
        )
        val cart_item7 = Class1_CartItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600",
            1
        )
        val cart_item8 = Class1_CartItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600",
            1
        )
        val cart_item9 = Class1_CartItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600",
            1
        )
        val cart_items: MutableList<Class1_CartItemsInfo> = mutableListOf(
            cart_item1,
            cart_item2,
            cart_item3,
            cart_item4,
            cart_item5,
            cart_item6,
            cart_item7,
            cart_item8,
            cart_item9
        )
        val adapter = Adapter2_CartItems(cart_items)
        binding.recyclerCartItems.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerCartItems.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}