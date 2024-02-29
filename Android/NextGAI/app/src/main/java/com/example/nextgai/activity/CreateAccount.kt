package com.example.nextgai.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.nextgai.R
import com.example.nextgai.databinding.ActivityCreateAccountBinding

class CreateAccount : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_create_account)
        loginPage()
        binding.signUpBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun loginPage() {
        binding.logintxt.setOnClickListener {
            val intent = Intent(this,LogIn::class.java)
            startActivity(intent)
        }
    }
}