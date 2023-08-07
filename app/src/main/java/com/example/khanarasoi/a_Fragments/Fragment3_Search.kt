package com.example.khanarasoi.a_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.khanarasoi.R
import com.example.khanarasoi.b_Adapter.Adapter1_FoodItems
import com.example.khanarasoi.c_Class.Class0_FoodItemsInfo
import com.example.khanarasoi.databinding.Fragment3SearchBinding

class Fragment3_Search : Fragment() {
    private val binding: Fragment3SearchBinding by lazy {
        Fragment3SearchBinding.inflate(layoutInflater)
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

        // Set food items with there price, food name , food image url
        val food1 = Class0_FoodItemsInfo("Vada Pao", 10, "https://img.freepik.com/free-photo/traditional-indian-soup-lentils-indian-dhal-spicy-curry-bowl-spices-herbs-rustic-black-wooden-table_2829-18717.jpg?size=626&ext=jpg")
        val food2 = Class0_FoodItemsInfo("Pav Bhaji", 20, "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600")
        val food3 = Class0_FoodItemsInfo("Vada Pao", 10, "https://img.freepik.com/free-photo/traditional-indian-soup-lentils-indian-dhal-spicy-curry-bowl-spices-herbs-rustic-black-wooden-table_2829-18717.jpg?size=626&ext=jpg")
        val food4 = Class0_FoodItemsInfo("Pav Bhaji", 20, "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600")
        val food5 = Class0_FoodItemsInfo("Vada Pao", 10, "https://img.freepik.com/free-photo/traditional-indian-soup-lentils-indian-dhal-spicy-curry-bowl-spices-herbs-rustic-black-wooden-table_2829-18717.jpg?size=626&ext=jpg")
        val food6 = Class0_FoodItemsInfo("Pav Bhaji", 20, "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600")
        val food_details = mutableListOf(food1, food2, food3, food4, food5, food6)
        val adapter = Adapter1_FoodItems(food_details)
        binding.recyclerFoodItems.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerFoodItems.adapter = adapter
    }
}
