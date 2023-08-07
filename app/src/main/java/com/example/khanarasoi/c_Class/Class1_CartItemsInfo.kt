package com.example.khanarasoi.c_Class

import java.net.URI

class Class1_CartItemsInfo(_name: String, _price: Int, _logo: String, _count: Int) {
    var food_name = ""
    var food_price = 0
    var food_logo = ""
    var item_count = 0

    init {
        food_name = _name
        food_price = _price
        food_logo = _logo
        item_count = _count
    }
}