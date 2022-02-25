package com.example.sarvarkhalmatov_exam_module_5.activity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.sarvarkhalmatov_exam_module_5.R
import com.example.sarvarkhalmatov_exam_module_5.adapter.ViewPagerAdapterSplash
import com.example.sarvarkhalmatov_exam_module_5.fragments.FragmentSplashFour
import com.example.sarvarkhalmatov_exam_module_5.fragments.FragmentSplashOne
import com.example.sarvarkhalmatov_exam_module_5.fragments.FragmentSplashThree
import com.example.sarvarkhalmatov_exam_module_5.fragments.FragmentSplashTwo
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class SplashActivity : AppCompatActivity() {
    private var viewPagerAdapter: ViewPagerAdapterSplash? = null
    private var viewPager: ViewPager? = null
    var wormDotsIndicator: WormDotsIndicator? = null
    lateinit var text_done :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initViews()
    }

    private fun initViews() {
        text_done = findViewById(R.id.tv_next)
        viewPager = findViewById(R.id.view_pager)
        viewPagerAdapter = ViewPagerAdapterSplash(supportFragmentManager)
        wormDotsIndicator = findViewById(R.id.worm_dots_indicator)

        viewPagerAdapter!!.add(FragmentSplashOne())
        viewPagerAdapter!!.add(FragmentSplashTwo())
        viewPagerAdapter!!.add(FragmentSplashThree())
        viewPagerAdapter!!.add(FragmentSplashFour())

        viewPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                 if(position == 3){
                     text_done.text = "Done"

                     text_done.setOnClickListener {
                         val intent = Intent(this@SplashActivity,MainActivity::class.java)
                         startActivity(intent)
                         //save it in sharedPreference
                         finish()
                     }
                 }else{
                     text_done.text = "Next"
                 }
            }

            override fun onPageScrollStateChanged(state: Int) {}

        })

        viewPager!!.adapter = viewPagerAdapter
        wormDotsIndicator!!.setViewPager(viewPager!!)
    }
}