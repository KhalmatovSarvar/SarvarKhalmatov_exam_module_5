package com.example.sarvarkhalmatov_exam_module_5.activity

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
    var text_done = findViewById<TextView>(R.id.tv_next)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initViews()
    }

    private fun initViews() {
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
                 }else{
                     text_done.text = "Done"
                 }
            }

            override fun onPageScrollStateChanged(state: Int) {}

        })

        viewPager!!.adapter = viewPagerAdapter
        wormDotsIndicator!!.setViewPager(viewPager!!)
    }
}