package com.example.khanarasoi.b_Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.khanarasoi.c_Class.Class0_FoodItemsInfo
import com.example.khanarasoi.c_Class.Class1_CartItemsInfo
import com.example.khanarasoi.databinding.Layout0FoodItemsBinding
import com.squareup.picasso.Picasso

class Adapter1_FoodItems() :
    RecyclerView.Adapter<Adapter1_FoodItems.Adapter_binding>() {
    lateinit var lst_cart: List<Class1_CartItemsInfo>
    private lateinit var food_details: List<Class0_FoodItemsInfo>
    constructor(food_details: List<Class0_FoodItemsInfo>) : this() {
        this.food_details = food_details
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_binding {
        return Adapter_binding(
            Layout0FoodItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return food_details.size
    }

    override fun onBindViewHolder(holder: Adapter_binding, position: Int) {
        val food_info = food_details[position]
        holder.binding.txtViewFoodName.text = food_info.food_name
        holder.binding.txtViewPrice.text = buildString {
            append("\u20B9")
            append(food_info.food_price.toString())
        }
        Picasso.get().load(food_info.food_image_url.toUri())
            .into(holder.binding.imageFilterViewFoodImg)

        holder.binding.btnAddToCart.setOnClickListener {
            var cart_details = Class1_CartItemsInfo(
                food_info.food_name,
                food_info.food_price,
                food_info.food_image_url,
                1
            )
            lst_cart += cart_details
        }
    }

    class Adapter_binding(val binding: Layout0FoodItemsBinding) :
        RecyclerView.ViewHolder(binding.root)
}