package com.example.khanarasoi.a_Fragments

import ApiService
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.khanarasoi.b_Adapter.Adapter1_FoodItems
import com.example.khanarasoi.c_Class.Class0_FoodItemsInfo
import com.example.khanarasoi.d_API.CategoriesResponse
import com.example.khanarasoi.d_API.LoginAdminResponse
import com.example.khanarasoi.d_API.LoginRequest
import com.example.khanarasoi.d_API.LoginResponse
import com.example.khanarasoi.databinding.Fragment1HomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Fragment1_Home : Fragment() {

    private lateinit var foodItems: List<CategoriesResponse>
    private val binding: Fragment1HomeBinding by lazy {
        Fragment1HomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnViewMenu.setOnClickListener {
            val menu = Fragment1_1_ViewMenu()
            menu.show(parentFragmentManager, "menu")
        }

        // Logged in using admin login id and password and getting
        val adminToken = adminLogin("chiragnikam02@gmail.com", "12345678")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Add image to Array List (of type SlideModel) by image links
        val imageList = ArrayList<SlideModel>()
        imageList.add(
            SlideModel(
                "https://img.freepik.com/free-psd/food-menu-restaurant-web-banner-template_120329-1771.jpg?size=626&ext=jpg",
                ScaleTypes.FIT
            )
        )
        imageList.add(
            SlideModel(
                "https://img.freepik.com/free-psd/food-menu-restaurant-facebook-cover-template_106176-731.jpg?size=626&ext=jpg",
                ScaleTypes.FIT
            )
        )
        imageList.add(
            SlideModel(
                "https://img.freepik.com/free-psd/food-menu-restaurant-web-banner-template_106176-422.jpg?size=626&ext=jpg",
                ScaleTypes.FIT
            )
        )

        // Set images of array list into image slider
        binding.imageSlider.setImageList(imageList)

        // Set food items with there price, food name , food image url
        val food1 = Class0_FoodItemsInfo(
            "Vada Pao",
            10,
            "https://img.freepik.com/free-photo/traditional-indian-soup-lentils-indian-dhal-spicy-curry-bowl-spices-herbs-rustic-black-wooden-table_2829-18717.jpg?size=626&ext=jpg"
        )
        val food2 = Class0_FoodItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600"
        )
        val food3 = Class0_FoodItemsInfo(
            "Pizza",
            30,
            "https://img.freepik.com/free-photo/freshly-italian-pizza-with-mozzarella-cheese-slice-generative-ai_188544-12347.jpg?size=626&ext=jpg"
        )
        val food4 = Class0_FoodItemsInfo(
            "Burger",
            10,
            "https://img.freepik.com/free-photo/front-view-burger-stand_141793-15542.jpg?size=626&ext=jpg"
        )
        val food5 = Class0_FoodItemsInfo(
            "Vada Pao",
            10,
            "https://img.freepik.com/free-photo/traditional-indian-soup-lentils-indian-dhal-spicy-curry-bowl-spices-herbs-rustic-black-wooden-table_2829-18717.jpg?size=626&ext=jpg"
        )
        val food6 = Class0_FoodItemsInfo(
            "Pav Bhaji",
            20,
            "https://images.lifestyleasia.com/wp-content/uploads/sites/7/2022/02/01171421/YFL-Pav-Bhaji-2.jpg?tr=w-1600"
        )
        val food_details = mutableListOf(food1, food2, food3, food4, food5, food6)
        val adapter = Adapter1_FoodItems(requireContext(), food_details)
        binding.recyclerFoodItems.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerFoodItems.adapter = adapter
    }

    private fun getAllCategories(token: String) {
        val apiService =
            RetrofitClient.getClient("http://137.184.27.168:8000").create(ApiService::class.java)
        val call = apiService.getAllCategories("Bearer $token")
        call.enqueue(object : Callback<CategoriesResponse> {
            override fun onResponse(
                call: Call<CategoriesResponse>,
                response: Response<CategoriesResponse>
            ) {
                Log.d("ResponseCode", "response code: ${response.code()}")
                if (response.isSuccessful) {
                    val categories = response.body()
                    if (categories != null) {
                        val categoriesInfo = categories.data
                        Log.i(
                            "category",
                            categoriesInfo[1].name
                        )
                    } else {
                        Log.e("data", "No Categories exists")
                    }
                } else {
                    Log.e("data", "Failed to get category|| ${response.code()}")
                }
            }

            override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
                Log.e("data", "Unable to load API. Unsuccessful!")
                t.message?.let { Log.e("data", it) }
            }

        })

    }

    // Admin Login
    private fun adminLogin(
        email: String, password: String
    ):String? {    // Check email and password are correct or not from the api
        var return_token: String? = null
        val apiService =
            RetrofitClient.getClient("http://137.184.27.168:8000").create(ApiService::class.java)
        val call = apiService.adminLogin(LoginRequest(email, password))
        call.enqueue(object : Callback<LoginAdminResponse> {
            override fun onResponse(call: Call<LoginAdminResponse>, response: Response<LoginAdminResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if (loginResponse != null) {
                        return_token = loginResponse.data.token
                    }
                    if (loginResponse != null) {
                        Log.d(
                            "admin_login_data",
                            "token: ${loginResponse.data.token}, name: ${loginResponse.data.admin.email}, email: ${loginResponse.data.admin.name}"
                        )
                    } else {
                        Log.e("data", "Login Unsuccessful")
                    }
                    if (loginResponse != null) {
                        getAllCategories(loginResponse.data.token)
                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Incorrect UserName or Password || ${response.body()?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            // If failed to load
            override fun onFailure(call: Call<LoginAdminResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "Network Error", Toast.LENGTH_SHORT).show()
            }
        })
        return_token?.let { Log.d("admin_token", it) }
        return return_token
    }
}