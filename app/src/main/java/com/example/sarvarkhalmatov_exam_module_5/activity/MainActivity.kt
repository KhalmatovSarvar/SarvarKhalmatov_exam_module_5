package com.example.sarvarkhalmatov_exam_module_5.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.sarvarkhalmatov_exam_module_5.R
import com.example.sarvarkhalmatov_exam_module_5.fragments.FilterFragment
import com.example.sarvarkhalmatov_exam_module_5.fragments.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews(){
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnClickListener {

        }

        replaceFragment(HomeFragment())
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(HomeFragment())
                R.id.ic_filter -> replaceFragment(FilterFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            commit()
        }
    }


}