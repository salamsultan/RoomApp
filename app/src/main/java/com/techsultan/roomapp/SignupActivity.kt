package com.techsultan.roomapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.techsultan.roomapp.databinding.ActivitySignupBinding
import com.techsultan.roomapp.db.UserRepository
import com.techsultan.roomapp.db.entity.UserEntity

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = binding.nameEt
        val email = binding.emailEt
        val  password = binding.passwordEt
        val button = binding.registerBtn

        button.setOnClickListener {

            val userAccount = UserEntity(0, username = name.text.toString().trim(), email = email.text.toString(),
                password = password.text.toString().trim())

            if (email.text.isNullOrBlank() || password.text.isNullOrBlank() || name.text.isNullOrBlank()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            }else{

                userRepository.insertUsers(userAccount)
                Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_LONG).show()
            }

        }

    }
}