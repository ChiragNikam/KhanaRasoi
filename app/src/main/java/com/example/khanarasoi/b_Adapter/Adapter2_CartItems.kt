package com.example.khanarasoi.b_Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.khanarasoi.c_Class.Class1_CartItemsInfo
import com.example.khanarasoi.databinding.Layout1CartItemsBinding
import com.squareup.picasso.Picasso

class Adapter2_CartItems(private val cartItems: List<Class1_CartItemsInfo>) :
    RecyclerView.Adapter<Adapter2_CartItems.Adapter_Binding>() {
    // bug here
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter_Binding {
        return Adapter_Binding(
            Layout1CartItemsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Adapter_Binding, position: Int) {
        val cart_item = cartItems[position]
        holder.binding.txtViewFoodName.text = cart_item.food_name
        holder.binding.txtViewFoodPrice.text = buildString {
            append("\u20B9")
            append(cart_item.food_price.toString())
        }
        holder.binding.txtViewItemCount.text = cart_item.item_count.toString()
        Picasso.get().load(cart_item.food_logo).into(holder.binding.imgCartFoodItem)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    class Adapter_Binding(val binding: Layout1CartItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

}