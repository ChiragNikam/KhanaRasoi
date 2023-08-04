package com.example.khanarasoi.a_Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.khanarasoi.R
import com.example.khanarasoi.databinding.Fragment1HomeBinding

class Fragment1_Home : Fragment() {
    private val binding: Fragment1HomeBinding by lazy {
        Fragment1HomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        val binding = Fragment1HomeBinding.inflate(inflater, container, false)
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
    }
}