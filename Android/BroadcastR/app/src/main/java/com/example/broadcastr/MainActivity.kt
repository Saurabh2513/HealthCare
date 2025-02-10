package com.example.broadcastr

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.broadcastr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var myBroadcastReceiver: MyBroadcastReceiver? = null
    var brDownload = object : BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            if (intent!=null){
                val path = intent.getStringExtra("path")
                binding.txtPath.text = path
                Toast.makeText(context,"download",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}