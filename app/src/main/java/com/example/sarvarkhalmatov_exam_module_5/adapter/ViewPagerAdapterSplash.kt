package com.example.sarvarkhalmatov_exam_module_5.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapterSplash(fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    private val fragments: MutableList<Fragment> = ArrayList()
    fun add(fm: Fragment) {
        fragments.add(fm)
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}