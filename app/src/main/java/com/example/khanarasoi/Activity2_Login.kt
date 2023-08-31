package com.example.khanarasoi

import ApiService
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.khanarasoi.d_API.LoginRequest
import com.example.khanarasoi.d_API.LoginResponse
import com.example.khanarasoi.databinding.Activity2LoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Activity2_Login : AppCompatActivity() {
    private val binding: Activity2LoginBinding by lazy {
        Activity2LoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.txtViewDontHaveAccount.setOnClickListener {
            val intent = Intent(this, Activity3_SignUp::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            userLogin(email, password)
        }
    }

    private fun userLogin(
        email: String, password: String
    ) {    // Check email and password are correct or not from the api
        val apiService =
            RetrofitClient.getClient("http://137.184.27.168:8000").create(ApiService::class.java)
        val call = apiService.userLogin(LoginRequest(email, password))
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        val loginSharedPreferences =
                            getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
                        val editor = loginSharedPreferences.edit()
                        editor.putString("token", loginResponse.data.token)
                        editor.putString("email", loginResponse.data.user.email)
                        editor.putString("password", loginResponse.data.user.password)
                        editor.putBoolean("logged", true)
                        editor.apply()

                        Log.d(
                            "login_data",
                            "token: ${loginResponse.data.token}, name: ${loginResponse.data.user.name}, email: ${loginResponse.data.user.email}"
                        )

                        val intent =
                            Intent(this@Activity2_Login, Activity4_ChoseLocation::class.java)
                        startActivity(intent)
                    } else {
                        Log.e("data", "Login Unsuccessful")
                    }
                } else {
                    Toast.makeText(
                        this@Activity2_Login,
                        "Incorrect UserName or Password || ${response.body()?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            // If failed to load
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(this@Activity2_Login, "Network Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}