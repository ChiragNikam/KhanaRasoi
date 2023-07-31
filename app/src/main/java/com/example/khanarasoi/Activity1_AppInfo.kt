package com.example.khanarasoi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.khanarasoi.databinding.Activity1AppInfoBinding

class Activity1_AppInfo : AppCompatActivity() {
    private val binding: Activity1AppInfoBinding by lazy {
        Activity1AppInfoBinding.inflate(layoutInflater)
    };
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonNext.setOnClickListener {
            val intent  = Intent(this, Activity2_Login::class.java)
            startActivity(intent)
        }
    }
}