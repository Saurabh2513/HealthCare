package com.example.base.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.base.R

class SecondActivity : AppCompatActivity() {

    lateinit var tvId: TextView
    lateinit var tvName: TextView
    
    lateinit var tvRoll: TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvId = findViewById(R.id.tvId)
        tvName = findViewById(R.id.tvName)
        tvRoll = findViewById(R.id.tvRoll)


        val bundle = intent.extras
        if (bundle != null) {
            tvId.text = "id =${bundle.getString("id")}"
            tvName.text = "Name =${bundle.getString("name")}"
            tvRoll.text = "rollNo =${bundle.getString("roll")}"
        }

    }
}