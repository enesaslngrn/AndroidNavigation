package com.example.androidnavigation

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.androidnavigation.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.firstFragment,
            R.id.secondFragment,
            R.id.thirdFragment,
            R.id.fourthFragment
        ),binding.drawerLayout)

        // Toolbar
        binding.materialToolbar.setupWithNavController(navController,appBarConfiguration)
        binding.materialToolbar.setOnMenuItemClickListener { menuItem ->
            menuItem.onNavDestinationSelected(findNavController(R.id.fragmentContainerView))
        }

        // Nav Drawer
        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.onNavDestinationSelected(findNavController(R.id.fragmentContainerView))
            binding.drawerLayout.close()
            true
        }
        // Bottom Nav View
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}