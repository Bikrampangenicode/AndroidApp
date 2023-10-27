package com.example.learnkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.learnkotlin.Adapter.ViewpagerAdapter
import com.example.learnkotlin.Ui_tab.CallFragment
import com.example.learnkotlin.Ui_tab.VideoCallFragment
import com.example.learnkotlin.databinding.ActivityCallScreenBinding

class CallScreen : AppCompatActivity() {

    private var binding : ActivityCallScreenBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallScreenBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        supportActionBar?.hide()

        val fragmentArrayList = ArrayList<Fragment>()

        fragmentArrayList.add(CallFragment())
        fragmentArrayList.add(VideoCallFragment())



        val adapter = ViewpagerAdapter(this, supportFragmentManager, fragmentArrayList)

        binding!!.viewpager.adapter =adapter

        binding!!.tabs.setupWithViewPager(binding!!.viewpager)
    }
}