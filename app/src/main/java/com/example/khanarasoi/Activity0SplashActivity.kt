package com.example.khanarasoi

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnticipateInterpolator
import android.window.SplashScreen
import androidx.annotation.RequiresApi
import androidx.core.animation.doOnEnd

class Activity0SplashActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
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