package com.example.khanarasoi.e_LocalDatabase.a_Entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Login")
class Login(_token: String, _email: String, _pass: String) {
    @ColumnInfo(name = "token")
    var token: String
    @ColumnInfo(name = "email")
    var email: String
    @ColumnInfo(name = "password")
    var password: String

    init {
        this.token = _token
        this.email = _email
        this.password = _pass
    }

    // Getters
    fun getToken(): String = token
    fun getEmail(): String = email
    fun getPass(): String = password

    // Setters
    fun setToken(token: String){ this.token = token}
    fun setEmail(email: String){ this.email = email}
    fun setPass(password: String){ this.password = password}
}