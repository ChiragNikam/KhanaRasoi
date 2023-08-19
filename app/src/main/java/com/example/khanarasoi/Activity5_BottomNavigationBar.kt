package com.example.khanarasoi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.khanarasoi.databinding.Activity5BottomNavigationBarBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Activity5_BottomNavigationBar : AppCompatActivity() {
    private val binding: Activity5BottomNavigationBarBinding by lazy {
        Activity5BottomNavigationBarBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // Obtain the NavHostFragment from the FragmentContainerView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        // setting the bottom navigation bar
        val bottomNavigationBar: BottomNavigationView = findViewById(R.id.bottom_navigation_bar)
        bottomNavigationBar.setupWithNavController(navController)
    }
}