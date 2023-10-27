package com.example.learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learnkotlin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.loginBack.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.buttonSignIn.setOnClickListener {

            startActivity(Intent(this,ProfileCompleteActivity::class.java))
            finish()
        }
    }
}