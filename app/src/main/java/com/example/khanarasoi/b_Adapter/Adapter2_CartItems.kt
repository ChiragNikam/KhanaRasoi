package com.example.khanarasoi.b_Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.khanarasoi.c_Class.Class1_CartItemsInfo
import com.example.khanarasoi.databinding.Layout1CartItemsBinding
import com.example.khanarasoi.databinding.Layout3CartEmptyItemBinding
import com.squareup.picasso.Picasso

class Adapter2_CartItems(private val cartItems: MutableList<Class1_CartItemsInfo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_CART_ITEM = 0
    private val VIEW_TYPE_EMPTY = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_CART_ITEM -> {
                val binding = Layout1CartItemsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                CartItemViewHolder(binding)
            }
            VIEW_TYPE_EMPTY -> {
                val binding = Layout3CartEmptyItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                EmptyViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CartItemViewHolder -> {
                val cart_item = cartItems[position]
                holder.binding.txtViewFoodName.text = cart_item.food_name
                holder.binding.txtViewFoodPrice.text = buildString {
                    append("\u20B9")
                    append(cart_item.food_price.toString())
                }
                holder.binding.txtViewItemCount.text = cart_item.item_count.toString()
                Picasso.get().load(cart_item.food_logo).into(holder.binding.imgCartFoodItem)

                holder.binding.btnPlus.setOnClickListener {
                    var item_count: Int = holder.binding.txtViewItemCount.text.toString().toInt()
                    if (item_count < 10) {
                        item_count++
                        holder.binding.txtViewItemCount.text = item_count.toString()
                    }
                }

                holder.binding.btnMunus.setOnClickListener {
                    var item_count: Int = holder.binding.txtViewItemCount.text.toString().toInt()
                    if (item_count > 1) {
                        item_count--
                        holder.binding.txtViewItemCount.text = item_count.toString()
                    } else {
                        deleteCartItem(position)
                    }
                }

                holder.binding.btnDelete.setOnClickListener {
                    deleteCartItem(position)
                }
            }
            is EmptyViewHolder -> {
                // No operation needed for the empty view
            }
        }
    }

    override fun getItemCount(): Int {
        return if (cartItems.isEmpty()) {
            0
        } else {
            cartItems.size + 1
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < cartItems.size) {
            VIEW_TYPE_CART_ITEM
        } else {
            VIEW_TYPE_EMPTY
        }
    }

    private fun deleteCartItem(position: Int) {
        cartItems.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, cartItems.size)
    }

    inner class CartItemViewHolder(val binding: Layout1CartItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class EmptyViewHolder(val binding: Layout3CartEmptyItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}
