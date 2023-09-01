package com.example.vistaraworld.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.vistaraworld.R
import com.example.vistaraworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mNavController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //set navigation drawer
        binding.iconDrawer.setOnClickListener {
            if (!binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }
        }


        //set bottom navigation
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment?

        val bottomNavigation = binding.bottomNavigation

        if (navHostFragment != null) {
            mNavController = navHostFragment.navController
            setupWithNavController(bottomNavigation, mNavController)
        }
    }
}