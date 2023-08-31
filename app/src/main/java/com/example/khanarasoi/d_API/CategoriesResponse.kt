package com.example.khanarasoi.d_API

data class CategoriesResponse(
    val status: Boolean,
    val data: List<Category>
)

data class Category(
    val _id: String,
    val name: String,
    val slug: String,
    val summary: String,
    val description: String,
    val parentCategoryId: String?,
    val status: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val __v: Int,
    val thumbnail: String?
)
