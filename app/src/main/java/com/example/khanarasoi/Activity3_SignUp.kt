package com.example.khanarasoi

import ApiService
import RetrofitClient
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.khanarasoi.d_API.LoginRequest
import com.example.khanarasoi.d_API.RegistrationRequest
import com.example.khanarasoi.d_API.RegistrationResponse
import com.example.khanarasoi.databinding.Activity3SignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            finish()
        }
        binding.btnCreateAccount.setOnClickListener {
            val name = binding.editTextUserName.text.toString()
            val email = binding.editTextEmail.text.toString()
            val phone = binding.editTextPhone.text.toString()
            val password = binding.editTextPassword.text.toString()
            createUser(name, email, phone, password)
        }
    }

    private fun createUser(name: String, email: String, phone: String, password: String) {
        val apiService =
            RetrofitClient.getClient("http://137.184.27.168:8000").create(ApiService::class.java)
        val call = apiService.register(
            RegistrationRequest(
                name,
                email,
                phone,
                password
            )
        )   // passing parameters of account to be created to the POST request
        call.enqueue(object : Callback<RegistrationResponse> {
            override fun onResponse(
                call: Call<RegistrationResponse>,
                response: Response<RegistrationResponse>
            ) {
                if (response.isSuccessful) {    // if sucessfull then it will move to get location
                    val registrationResponse = response.body()
                    Toast.makeText(
                        this@Activity3_SignUp,
                        "Account Created Successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("signUp_response", "code: ${response.code()}")
                    if (registrationResponse != null) {
                        // SignUp Response coming after the POST request of Registration
                        Log.d(
                            "signUp_response",
                            "name: ${registrationResponse.data.name}, email: ${registrationResponse.data.email}, phone: ${registrationResponse.data.phone}, password: ${registrationResponse.data.password}"
                        )
                    }
                    val intent = Intent(this@Activity3_SignUp, Activity4_ChoseLocation::class.java)
                    startActivity(intent)
                } else {
                    val registrationResponse = response.body()?.message
                    Toast.makeText(
                        this@Activity3_SignUp,
                        registrationResponse,
                        Toast.LENGTH_LONG
                    ).show()
                    Log.d("signUp_response", "response $registrationResponse")

                }
            }

            override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                t.message?.let { Log.e("signUp_error", it) }
            }
        })
    }
}