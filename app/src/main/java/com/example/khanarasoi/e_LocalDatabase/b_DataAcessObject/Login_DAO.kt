package com.example.khanarasoi.e_LocalDatabase.b_DataAcessObject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.khanarasoi.e_LocalDatabase.a_Entities.Login
import androidx.room.Query
import androidx.room.Update

@Dao
interface Login_DAO {
    @Query("SELECT * FROM Login")
    fun getUser(): List<Login>

    @Insert
    fun insertUser(user: Login)

    @Delete
    fun deleteUser(user: Login)

    @Update
    fun updateUser(user: Login)
}