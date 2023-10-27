package com.example.learnkotlin

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Button
import android.net.Uri
import android.provider.ContactsContract.Data
import android.widget.AdapterView
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext


import com.example.learnkotlin.databinding.ActivityProfileCompleteBinding
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ProfileCompleteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileCompleteBinding


    private lateinit var imageView: ImageView
    private lateinit var button: FloatingActionButton

    private lateinit var selectedImage: Uri


    override fun onResume() {
        super.onResume()
        val packages =resources.getStringArray(R.array.package_select)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdownitem,packages)
        binding.packageAutocomplete.setAdapter(arrayAdapter)


        val package_status = resources.getStringArray(R.array.status_dropdown)
        val arrayAdapter_status = ArrayAdapter(this,R.layout.statusdropdown,package_status)
        binding.statusAutocomplete.setAdapter(arrayAdapter_status)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityProfileCompleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        imageView = findViewById(R.id.profilePick)


        binding.profilePicker.setOnClickListener{
      ImagePicker.with(this)
            .crop(0.5f,0.5f)	    			//Crop image(Optional), Check Customization for more option
               .compress(1024)			//Final image size will be less than 1 MB(Optional)
           .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
            .start(1)


        }




        binding.CompleteButton.setOnClickListener {


        if (binding.userNameText.text!!.isEmpty() or binding.statusAutocomplete.text!!.isEmpty() or binding.packageAutocomplete.text!!.isEmpty() ) {
             Toast.makeText(this, "please Fill all the values ", Toast.LENGTH_SHORT).show()


     }

        else{
            startActivity(Intent(this,CallScreen::class.java))
            finish()
        }

        }

            binding.loginBack.setOnClickListener {
                startActivity((Intent(this, LoginActivity::class.java)))
                finish()
            }

        }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
         if(data!= null) {
             if(data.data!= null){
             imageView.setImageURI(data?.data)



             }
         }
    }

}
