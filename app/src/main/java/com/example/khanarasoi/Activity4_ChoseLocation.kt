package com.example.khanarasoi

import ApiService
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.khanarasoi.d_API.UserProfileResponse
import com.example.khanarasoi.databinding.Activity3SignUpBinding
import com.example.khanarasoi.databinding.Activity4ChoseLocationBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Activity4_ChoseLocation : AppCompatActivity() {
    private val binding: Activity4ChoseLocationBinding by lazy {
        Activity4ChoseLocationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val token = intent.getStringExtra("token")
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val password = intent.getStringExtra("password")
        if (token != null) {
            getUser(token)
        }
        binding.btnGoNext.setOnClickListener {
            val intent = Intent(this, Activity5_BottomNavigationBar::class.java)
            startActivity(intent)
        }
    }

    fun getUser(token: String){
        val apiService = RetrofitClient.getClient("http://137.184.27.168:8000").create(ApiService::class.java)
        val call = apiService.getUserProfile("Bearer $token")
        call.enqueue(object : Callback<UserProfileResponse> {
            override fun onResponse(call: Call<UserProfileResponse>, response: Response<UserProfileResponse>) {
                Log.d("ResponseCode", "response code: ${response.code()}")
                if (response.isSuccessful) {
                    val userProfileResponse = response.body()
                    if (userProfileResponse != null) {
                        val userProfile = userProfileResponse.data
                        Log.d("userProfile", "Name: ${userProfile.name}, Email: ${userProfile.email}")
                    } else {
                        Log.e("data", "User profile response body is null")
                    }
                } else {
                    Log.e("data", "Failed to get user profile")
                }
            }

            override fun onFailure(call: Call<UserProfileResponse>, t: Throwable) {
                Log.e("data", "Unable to load API. Unsuccessful!")
                t.message?.let { Log.e("data", it) }
            }
        })

    }
}