package com.example.khanarasoi.d_API

data class RegistrationResponse (
    val status: String,
    val message: String,
    val data: SignUpInfo
){
    data class SignUpInfo(
        val name: String,
        val email: String,
        val phone: String,
        val password: String,
        val status: Boolean
    )
}
