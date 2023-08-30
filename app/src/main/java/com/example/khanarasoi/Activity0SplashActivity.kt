package com.example.khanarasoi

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.annotation.RequiresApi

@SuppressLint("CustomSplashScreen")
class Activity0SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity0_splash_activity)

        Handler().postDelayed({
            val sharedPreferences = getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
            if(sharedPreferences.getBoolean("logged", false)) {
                val intent = Intent(this, Activity5_BottomNavigationBar::class.java)
                startActivity(intent)
                finish()
            } else{
                val intent = Intent(this, Activity1_AppInfo::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }
}