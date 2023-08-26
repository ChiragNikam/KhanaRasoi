package com.example.khanarasoi.d_API

data class LoginResponse (
    val status: Boolean,
    val message: String,
    val data: Data
) {
    data class Data(
        val token: String,
        val user: UserData
    ) {
        data class UserData(
            val _id: String,
            val name: String,
            val email: String,
            val phone: String,
            val password: String,
            val status: Boolean,
            val createdAt: String,
            val updatedAt: String,
            val __v: Int
        )
    }
}
