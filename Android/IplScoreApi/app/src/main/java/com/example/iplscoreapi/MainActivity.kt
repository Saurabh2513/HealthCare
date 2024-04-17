package com.example.iplscoreapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import androidx.lifecycle.lifecycleScope
import com.example.iplscoreapi.adapter.MatchAdapter
import com.example.iplscoreapi.api.ApiInterface
import com.example.iplscoreapi.api.ApiUtilities
import com.example.iplscoreapi.constant.Constant.API_KEY
import com.example.iplscoreapi.constant.Constant.SERIES_ID
import com.example.iplscoreapi.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val matchApi = ApiUtilities.getInstance().create(ApiInterface::class.java)
        lifecycleScope.launch(Dispatchers.IO) {
            val result = matchApi.getSeries(API_KEY, SERIES_ID)

            if (result.body() != null) {
                Log.d("Sagar", "onCreate: ${result.body()!!.data.matchList}")

                withContext(Dispatchers.Main) {
                    binding.progressbar.visibility = GONE
                    binding.recyclerView.adapter =
                        MatchAdapter(this@MainActivity, result.body()!!.data.matchList)
                }
            }
        }
    }
}