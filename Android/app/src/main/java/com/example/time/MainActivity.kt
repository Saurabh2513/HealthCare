package com.example.time

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.realtime.api.TimeAPI
import com.example.realtime.api.TimeModel
import com.example.time.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        TimeAPI.create().getTime().enqueue(object : Callback<TimeModel> {
            override fun onResponse(p0: Call<TimeModel>, p1: Response<TimeModel>) {
                binding.progress.visibility = View.GONE
                binding.time.visibility = View.VISIBLE
                binding.time.text =
                    "Time: ${p1.body()?.time} \n Date: ${p1.body()?.date} \n TimeZone: ${p1.body()?.timeZone} \n DayOfWeek: ${p1.body()?.dayOfWeek} \n DateTime: ${p1.body()?.dateTime} \n Year: ${p1.body()?.year}"

            }

            override fun onFailure(p0: Call<TimeModel>, p1: Throwable) {
                Toast.makeText(this@MainActivity, "Error: ${p1.message}", Toast.LENGTH_SHORT).show()
            }

        })

    }
}