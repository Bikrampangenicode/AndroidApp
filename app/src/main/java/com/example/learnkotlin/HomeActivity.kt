package com.example.learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learnkotlin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnSignInUsername.setOnClickListener{

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        binding.signUp.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        binding.signinPhonenum.setOnClickListener {

            startActivity(Intent(this, PhoneLoginActivity::class.java))
            finish()
        }



    }
}