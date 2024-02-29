package com.example.nextgai.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.nextgai.R
import com.example.nextgai.databinding.ActivityExploreBinding
import java.util.zip.Inflater

class Explore : AppCompatActivity() {
    private lateinit var binding: ActivityExploreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_explore)


    }
}