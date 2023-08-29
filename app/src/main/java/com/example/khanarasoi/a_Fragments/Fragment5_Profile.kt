package com.example.khanarasoi.a_Fragments

import ApiService
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.khanarasoi.d_API.UserProfileResponse
import com.example.khanarasoi.databinding.Fragment5ProfileBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Fragment5_Profile : Fragment() {
    private val binding: Fragment5ProfileBinding by lazy {
        Fragment5ProfileBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnSetProfilePicture.setOnClickListener {
            openGallery()
        }

        binding.imgViewEditName.setOnClickListener {
            binding.editTextUserName.isEnabled = true
        }

        binding.imgViewEditEmail.setOnClickListener {
            binding.editTextEmail.isEnabled = true
        }

        binding.imgViewEditPhone.setOnClickListener {
            binding.editTextPhoneNo.isEnabled = true
        }

        // Getting Token from
        val loginSharedPreferences = requireActivity().getSharedPreferences("LoginDetails", Context.MODE_PRIVATE)
        val token = loginSharedPreferences.getString("token", "")
        getUser(token.toString())
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri = data.data
            binding.imgProfile.setImageURI(imageUri)
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, 1)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun getUser(token: String){
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
                        binding.editTextEmail.setText(userProfile.email)
                        binding.editTextUserName.setText(userProfile.name)
                        binding.editTextPhoneNo.setText(userProfile.phone)
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