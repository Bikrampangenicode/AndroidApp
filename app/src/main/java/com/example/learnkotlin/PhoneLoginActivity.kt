package com.example.learnkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.learnkotlin.databinding.ActivityLoginBinding
import com.example.learnkotlin.databinding.ActivityPhoneLoginBinding
import com.google.android.material.textfield.TextInputEditText
import com.hbb20.CountryCodePicker
import java.util.zip.Inflater

class PhoneLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhoneLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
                //Declearing and initializing CountryCode
        val ccp:CountryCodePicker = findViewById(R.id.ccp)
        val phonenumberInput:TextInputEditText = findViewById(R.id.phonenumberInput)


        //connecting country code with phone number

        ccp.registerCarrierNumberEditText(phonenumberInput)

        val btncheck : Button  = findViewById(R.id.btn_signin_phonenum)

        btncheck.setOnClickListener {
            Toast.makeText(this, "Number is :" + ccp.fullNumber, Toast.LENGTH_LONG).show()
        }


        //Make all the button function

        binding.loginBack.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }
        binding.signUp.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
  binding.btnSigninPhonenum.setOnClickListener {
            startActivity(Intent(this,ProfileCompleteActivity::class.java))
        }

      //for the error if the number is more than 10
        binding.phonenumberInput.doOnTextChanged { text, start, before, count ->


            if (   text!!.length >=11){

                binding.phonenumberInput.error ="Please check the Phone number"
            }
        }


    }
}