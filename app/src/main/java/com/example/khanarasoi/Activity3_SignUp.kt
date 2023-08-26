package com.example.khanarasoi

import ApiService
import RetrofitClient
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.khanarasoi.d_API.LoginRequest
import com.example.khanarasoi.d_API.RegistrationRequest
import com.example.khanarasoi.databinding.Activity3SignUpBinding

class Activity3_SignUp : AppCompatActivity() {
    private val binding: Activity3SignUpBinding by lazy {
        Activity3SignUpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.txtViewHaveAccount.setOnClickListener {
            val intent = Intent(this, Activity2_Login::class.java)
            startActivity(intent)
        }
        binding.btnCreateAccount.setOnClickListener {
            val intent = Intent(this, Activity4_ChoseLocation::class.java)
            startActivity(intent)
        }
    }

    private fun createUser(name: String, email: String, phone: String, password: String){
        val apiService =
            RetrofitClient.getClient("http://137.184.27.168:8000").create(ApiService::class.java)
        val call = apiService.register(RegistrationRequest(name, email, phone, password))

    }
}