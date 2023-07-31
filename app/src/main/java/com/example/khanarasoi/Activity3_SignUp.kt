package com.example.khanarasoi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.khanarasoi.databinding.Activity3SignUpBinding

class Activity3_SignUp : AppCompatActivity() {
    private val binding : Activity3SignUpBinding by lazy {
        Activity3SignUpBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.txtViewHaveAccount.setOnClickListener{
            val intent = Intent(this, Activity2_Login::class.java)
            startActivity(intent)
        }
        binding.btnCreateAccount.setOnClickListener{
            val intent = Intent(this, Activity4_ChoseLocation::class.java)
            startActivity(intent)
        }
    }
}