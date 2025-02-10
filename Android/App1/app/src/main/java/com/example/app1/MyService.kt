package com.example.app1

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews

import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
const val channelId="notification_Channel"
const val channelName="My_channel_notification"
class MyService:FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
            createNotification(message.notification!!.title!!,message.notification!!.body!!)
    }

    @SuppressLint("RemoteViewLayout")
   // private fun notificationRemoteView(title:String, message: String): RemoteViews?
   // {
       //val notificationRemoteView=RemoteViews("")
        //notificationRemoteView.setTextViewText(R.id.title,title)
       // notificationRemoteView.setTextViewText(R.id.message,message)
       // notificationRemoteView.setImageViewResource(R.id.image1,R.drawable.ic_launcher_background)
       // return notificationRemoteView
    }

    fun createNotification(title:String,message:String)
    {
        val intent=Intent(this,MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_MUTABLE)

        var notification:NotificationCompat.Builder=NotificationCompat.Builder(applicationContext, channelId)
        notification.setSmallIcon(R.drawable.ic_launcher_background)
        notification.setAutoCancel(true)
        notification.setVibrate(longArrayOf(200,200,200,200))
        notification.setOnlyAlertOnce(true)
        notification.setContentIntent(pendingIntent)

        notification=notification.setContent(notificationRemoteView(title,message))
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            val channel=NotificationChannel(channelId, channelName,NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(0,notification.build())
    }
}