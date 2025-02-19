package com.akm.android_practice_1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.akm.android_practice_1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        val userName = binding.username.toString()
//        val password = binding.password.toString()

//        binding.login.setOnClickListener {
//            if(userName.isNotEmpty() && password.isNotEmpty()){
//                Toast.makeText(this, "Username ${userName}, Password is ${password}", Toast.LENGTH_SHORT).show()
//            }else {
//                Toast.makeText(this, "Username or password is missing!", Toast.LENGTH_SHORT).show()
//            }
//        }

    }
}

