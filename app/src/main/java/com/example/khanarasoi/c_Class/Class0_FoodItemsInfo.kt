package com.example.khanarasoi.c_Class

class Class0_FoodItemsInfo(val _name: String, val _price: Int, val _image_url: String) {
    public var food_name = ""
    public var food_price = 0
    public var food_image_url = ""
    init {
        this.food_name = _name
        this.food_price = _price
        this.food_image_url = _image_url
    }
}