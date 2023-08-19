package com.example.khanarasoi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.khanarasoi.databinding.Activity3SignUpBinding
import com.example.khanarasoi.databinding.Activity4ChoseLocationBinding

class Activity4_ChoseLocation : AppCompatActivity() {
    private val binding: Activity4ChoseLocationBinding by lazy {
        Activity4ChoseLocationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnGoNext.setOnClickListener {
            val intent = Intent(this, Activity5_BottomNavigationBar::class.java)
            startActivity(intent)
        }
    }
}