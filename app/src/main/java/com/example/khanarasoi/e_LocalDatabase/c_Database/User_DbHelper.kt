package com.example.khanarasoi.e_LocalDatabase.c_Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.khanarasoi.e_LocalDatabase.a_Entities.Login
import com.example.khanarasoi.e_LocalDatabase.b_DataAcessObject.Login_DAO

@Database(
    entities = [Login::class],
    version = 1
)
abstract class User_DbHelper : RoomDatabase() {
    private val PREF_NAME = "com.example.dhanlabh.EXPENSE_PREFS"
    private val KEY_CATEGORIES_INSERTED = "CATEGORIES_INSERTED"
    private var instance: User_DbHelper? = null

    @Synchronized
    fun getDb(context: Context?): User_DbHelper {
        if (instance == null) {
            instance = Room.databaseBuilder(
                context!!,
                User_DbHelper::class.java, "KhanaRasoi"
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
        return instance as User_DbHelper
    }

    abstract fun userDAO(): Login_DAO
}