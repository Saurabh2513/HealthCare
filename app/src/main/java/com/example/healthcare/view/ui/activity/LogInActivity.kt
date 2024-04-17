package com.example.healthcare.view.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.healthcare.R
import com.example.healthcare.databinding.ActivityLogInBinding
import com.example.healthcare.view.ui.fragment.Account
import com.google.android.play.integrity.internal.t
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.logIn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.password.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields are not allow !!", Toast.LENGTH_SHORT).show()
            }


            val fragment = Account()
            val x = binding.emailEt.text.toString()
            val bundle = Bundle()
            bundle.putString("userName", x)
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction().add(R.id.accountName, fragment).commit()

//            if (binding.userName.text.isEmpty()) {
//                Toast.makeText(this, "UserName!!", Toast.LENGTH_SHORT).show()
//            } else if (binding.confirmPassword.text.isEmpty()) {
//                Toast.makeText(this, "Password", Toast.LENGTH_SHORT).show()
//            } else {
//                val intent = Intent(this, MainActivity::class.java)
//                intent.putExtras(bundle)
//                startActivity(intent)
//            }
//        }
            binding.noAccount.setOnClickListener {
                val intent = Intent(this, Registration::class.java)
                startActivity(intent)
            }
            binding.skip.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}