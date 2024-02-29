package com.example.nextgai.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.nextgai.R
import com.example.nextgai.databinding.ActivityExploreBinding

class Explore : AppCompatActivity() {
    private lateinit var binding: ActivityExploreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_explore)
        binding.exploreBtn.setOnClickListener {
            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
        }

    }
}