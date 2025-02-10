package com.example.alarmapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Vibrator
import android.widget.Toast


class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (action != null) {
            when (action) {
                "ACTION_SNOOZE" -> {
                    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                    vibrator.vibrate(4000)

                    Toast.makeText(context, "Alarm! Wake up! Wake up!", Toast.LENGTH_LONG).show()
                    var alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
                    if (alarmUri == null) {
                        alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                    }

                    // setting default ringtone

                    // setting default ringtone
                    val ringtone = RingtoneManager.getRingtone(context, alarmUri)

                    // play ringtone

                    // play ringtone
                    ringtone.play()
                    Toast.makeText(context, "Alarm snoozed", Toast.LENGTH_SHORT).show()
                }
                "ACTION_DISMISS" -> {
                    // Handle dismiss action
                    Toast.makeText(context, "Alarm dismissed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}