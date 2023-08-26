package com.example.khanarasoi.d_API


data class UserProfileResponse (
    val status: Boolean,
    val data: UserInfo
){
    data class UserInfo(
        val _id: String,
        val name: String,
        val email: String,
        val phone: String,
        val password: String,
        val status: Boolean,
        val createdAt: String,
        val updatedAt: String
    )
}
