package com.example.healthcare.view.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.healthcare.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth

class Registration : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding

    // firebase auth var created
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // initialize the firebase auth to get Instance from firebase auth class
        firebaseAuth = FirebaseAuth.getInstance()
        // then press the button to set on clickListener
        binding.saveData.setOnClickListener {

            // the initialize thi id  or get id
            val email = binding.emailEt.text.toString()
            val pass = binding.pass.text.toString()
            val confirmPass = binding.confirmPassword.text.toString()

            // if check the is email and password is not empty or not
            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                // check password and confirm password was correct/Same or not
                if (pass == confirmPass) {
                    // same password then create firebase aut and create the user from firebase or save the id and password
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        // this user create the successful then pass the user from main activity
                        if (it.isSuccessful) {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty Fields are not allow ", Toast.LENGTH_SHORT).show()
            }
        }
        binding.signUp.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }
        binding.skip.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

//    private fun validateData() {
//
//        if (binding.emailEt.text.toString().isEmpty()) {
//
//            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show()
//        } else if (binding.userNameEt.text.toString().isEmpty()) {
//            Toast.makeText(this, "Enter Email Address", Toast.LENGTH_SHORT).show()
//        } else if (binding.password.text.toString().isEmpty()) {
//            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
//        } else if (!binding.termCondition.isChecked) {
//            Toast.makeText(this, "Accept Terms and Condition", Toast.LENGTH_SHORT).show()
//        } else {
//
//            val bundle = Bundle()
//            bundle.putString("RName", R.id.emailEt.toString())
//            bundle.putString("Email", R.id.userNameEt.toString())
//            val intent = Intent(this, MainActivity::class.java)
//            intent.putExtras(bundle)
//            startActivity(intent)
//            finish()
//        }
//
//    }
}