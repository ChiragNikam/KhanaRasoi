package com.example.khanarasoi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.khanarasoi.databinding.Activity1AppInfoBinding
import com.example.khanarasoi.databinding.Activity2LoginBinding

class Activity2_Login : AppCompatActivity() {
    private val binding: Activity2LoginBinding by lazy {
        Activity2LoginBinding.inflate(layoutInflater)
    };

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.txtViewDontHaveAccount.setOnClickListener {
            val intent = Intent(this, Activity3_SignUp::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, Activity4_ChoseLocation::class.java)
            startActivity(intent)
        }
    }
}