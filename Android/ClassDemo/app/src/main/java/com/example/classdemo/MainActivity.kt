package com.example.classdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.classdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun checkValidation(){
        if(binding.FirstName.text!=null && binding.LastName.text!=null && binding.City.text!=null
            && binding.date.text!=null && binding.PinCode.text!=null
        )
        {
            binding.Submit.setOnClickListener {

            }
        }
    }
}