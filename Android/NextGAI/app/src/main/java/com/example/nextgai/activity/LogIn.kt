package com.example.nextgai.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.nextgai.R
import com.example.nextgai.databinding.ActivityCreateAccountBinding
import com.example.nextgai.databinding.ActivityLogInBinding

class LogIn : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_log_in)
        createAccountPage()
        binding.loginUpBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun createAccountPage() {
        binding.createaccbtn.setOnClickListener {
            val intent = Intent(this,CreateAccount::class.java)
            startActivity(intent)
        }
    }
}