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
import com.example.khanarasoi.databinding.Fragment11ViewMenuBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Fragment1_1_ViewMenu : BottomSheetDialogFragment() {

    private lateinit var
            binding: Fragment11ViewMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = Fragment11ViewMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set food items with there price, food name , food image url
        val food1 = Class0_FoodItemsInfo(
            "Vada Pao",
            10,
            "https://img.freepik.com/free-photo/traditional-indian-soup-lentils-indian-dhal-spicy-curry-bowl-spices-herbs-rustic-black-wooden-table_2829-18717.jpg?size=626&ext=jpg"
        )
        val food2 = Class0_FoodItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600"
        )
        val food3 = Class0_FoodItemsInfo(
            "Pizza",
            30,
            "https://img.freepik.com/free-photo/freshly-italian-pizza-with-mozzarella-cheese-slice-generative-ai_188544-12347.jpg?size=626&ext=jpg"
        )
        val food4 = Class0_FoodItemsInfo(
            "Burgeer",
            10,
            "https://img.freepik.com/free-photo/front-view-burger-stand_141793-15542.jpg?size=626&ext=jpg"
        )
        val food5 = Class0_FoodItemsInfo(
            "Vada Pao",
            10,
            "https://img.freepik.com/free-photo/traditional-indian-soup-lentils-indian-dhal-spicy-curry-bowl-spices-herbs-rustic-black-wooden-table_2829-18717.jpg?size=626&ext=jpg"
        )
        val food6 = Class0_FoodItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600"
        )
        val food7 = Class0_FoodItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600"
        )
        val food8 = Class0_FoodItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600"
        )
        val food9 = Class0_FoodItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600"
        )
        val food10 = Class0_FoodItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600"
        )
        val food_details =
            mutableListOf(food1, food2, food3, food4, food5, food6, food7, food8, food9, food10)
        val adapter = Adapter1_FoodItems(food_details)
        binding.recyclerMenu.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerMenu.adapter = adapter
    }
}