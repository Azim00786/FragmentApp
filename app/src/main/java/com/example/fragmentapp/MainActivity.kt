package com.example.fragmentapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerlayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val navigation = findViewById<NavigationView>(R.id.navigationView)
        val bottomnavigation = findViewById<BottomNavigationView>(R.id.buttonNavigation)
        bottomnavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.addFragment1 -> {

                    changeFragment(HomeFragment())

                }
                R.id.addFragment2 -> changeFragment(SettingFragment())
                R.id.addFragment3 -> changeFragment(Fragment_profile())
            }

            true
        }

        toolbar.setNavigationOnClickListener {
            drawerlayout.open()
        }


        navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.addFragment1 -> {
                    changeFragment(HomeFragment())
                    Toast.makeText(this, "azim", Toast.LENGTH_SHORT).show()

                }

                R.id.addFragment2 -> changeFragment(SettingFragment())
                R.id.addFragment3 -> changeFragment(Fragment_profile())
            }
            drawerlayout.close()
            true
        }
    }

    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
    }
}