package com.example.learnkotlin.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewpagerAdapter(

    private val context: Context,
    fm: FragmentManager?,
val list: ArrayList<Fragment>
):FragmentPagerAdapter(fm!!){
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_NAME[position]
    }

    companion object{

        val TAB_NAME = arrayOf("call","Videocall")
    }

}

