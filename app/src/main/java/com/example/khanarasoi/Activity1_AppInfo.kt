package com.example.khanarasoi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity1_AppInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity1_main_activity)
        val button = findViewById<Button>(R.id.button_next)
        button.setOnClickListener {
            val intent  = Intent(this, Activity2_Login::class.java)
            startActivity(intent)
        }
    }
}