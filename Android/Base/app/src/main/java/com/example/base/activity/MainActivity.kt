package com.example.base.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.base.R
import com.example.base.databinding.ActivityMainBinding
import com.example.base.fragment.Home
import com.example.base.fragment.Profile
import com.example.base.fragment.Setting

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var etId: EditText
    lateinit var etName: EditText
    lateinit var etRoll: EditText
    lateinit var btnSend: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {


            when (it.itemId) {
                R.id.home -> {
                    replaysFragment(Home())
                    true
                }

                R.id.profile -> {
                    replaysFragment(Profile())
                    true
                }

                R.id.setting -> {
                    replaysFragment(Setting())
                    true
                }

                else -> {

                }
            }
            true
        }


        etId = findViewById(R.id.etId)
        etName = findViewById(R.id.etName)
        etRoll = findViewById(R.id.etRoll)
        btnSend = findViewById(R.id.btnSend)

        btnSend.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("id", etId.text.toString())
            bundle.putString("name", etName.text.toString())
            bundle.putString("roll", etRoll.text.toString())

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)

        }

    }

    private fun replaysFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.commit()
        fragmentTransaction.commit()
    }

}