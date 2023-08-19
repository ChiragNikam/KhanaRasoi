package com.example.khanarasoi

import android.annotation.SuppressLint
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
            val intent = Intent(this, Activity1_AppInfo::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}