package com.example.khanarasoi.e_LocalDatabase.a_Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Login")
class Login(_token: String, _email: String, _pass: String) {
    @ColumnInfo(name = "token")
    var token_id: String
    @ColumnInfo(name = "email")
    var user_email: String
    @ColumnInfo(name = "password")
    var user_password: String

    init {
        this.token_id = _token
        this.user_email = _email
        this.user_password = _pass
    }

    // Getters
    fun getToken(): String = token_id
    fun getEmail(): String = user_email
    fun getPass(): String = user_password

    // Setters
    fun setToken(token: String){ this.token_id = token}
    fun setEmail(email: String){ this.user_email = email}
    fun setPass(password: String){ this.user_password = password}
}