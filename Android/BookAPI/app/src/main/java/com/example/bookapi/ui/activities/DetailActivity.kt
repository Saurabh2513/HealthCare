package com.example.bookapi.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.bookapi.R
import com.example.bookapi.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("heading")
        val description = intent.getStringExtra("description")
        val imageId = intent.getIntExtra("imageId",R.drawable.ic_android_black_24dp)

        binding.bookDetailTitle.text = title
        binding.bookDetailText.text = description
        binding.bookImage.setImageResource(imageId)
    }
}