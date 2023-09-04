package com.example.khanarasoi.b_Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.khanarasoi.Activity5_BottomNavigationBar
import com.example.khanarasoi.c_Class.Class0_FoodItemsInfo
import com.example.khanarasoi.databinding.Layout0FoodItemsBinding
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class Adapter1_FoodItems(var context: Context, var food_details: List<Class0_FoodItemsInfo>) :
    RecyclerView.Adapter<Adapter1_FoodItems.Adapter_binding>() {

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
            showSnackbar("Added to Cart", "Go To Cart")
        }
    }

    private fun showSnackbar(message: String, action: String) {
        val rootView: View = (context as Activity5_BottomNavigationBar).window.decorView.findViewById(android.R.id.content)
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).setAction(action){
//            val fragmentManager = (context as AppCompatActivity).supportFragmentManager
//
//            val fragmentTransaction = fragmentManager.beginTransaction()
//            val fragment2 = Fragment2_Cart() // Replace with the actual class name of Fragment2
//            fragmentTransaction.replace(R.id.fragment_container_view, fragment2)
//            fragmentTransaction.addToBackStack(null) // Add to back stack if needed
//            fragmentTransaction.commit()
        }.show()
    }

    class Adapter_binding(val binding: Layout0FoodItemsBinding) :
        RecyclerView.ViewHolder(binding.root)
}