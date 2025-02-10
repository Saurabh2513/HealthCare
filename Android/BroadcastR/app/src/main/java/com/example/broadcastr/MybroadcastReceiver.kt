package com.example.broadcastr

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val modeChanged = intent?.getBundleExtra("state",false) ?:return
    }
}