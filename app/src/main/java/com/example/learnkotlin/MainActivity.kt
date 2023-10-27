package com.example.learnkotlin


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

//Splash screen
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 supportActionBar?.hide()

        Handler().postDelayed({

        val splash = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(splash)
            finish()
        },3000)
    }
}