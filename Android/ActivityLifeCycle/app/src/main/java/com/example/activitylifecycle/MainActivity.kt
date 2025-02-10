package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //first method in Activity LifeCycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        makingToast("onCreate")
    }

    fun makingToast(text:String){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
    }
    override fun onStart() {
        super.onStart()
        makingToast("onCreate")
    }

    override fun onResume() {
        super.onResume()
        makingToast("onResume")
    }

    override fun onPause() {
        super.onPause()
        makingToast("onPause")
    }

    override fun onStop() {
        super.onStop()
        makingToast("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        makingToast("onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        makingToast("onRestart")
    }
}