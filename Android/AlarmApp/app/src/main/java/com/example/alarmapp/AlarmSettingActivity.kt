package com.example.alarmapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AlarmSettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_setting)

        val saveAlarmButton: Button = findViewById(R.id.saveAlarmButton)
        saveAlarmButton.setOnClickListener {
            // Handle saving alarm logic
        }
    }
}