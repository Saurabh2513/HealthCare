package com.example.firebase

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.firebase.R.layout.notification
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

const val channelId="notification_channel"
const val channelName="Notification"
class MyFireBaseMessagingService:FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        if (message.notification!=null)
        {
            createNotification(message.notification!!.title!!,message.notification!!.body!!)
        }
        Log.e("tag","${message.notification?.body}")
    }
    @SuppressLint("RemoteViewLayout")
    fun getRemoteView(title: String, message: String):RemoteViews
    {
        val remoteViews=RemoteViews("com.example.firebase",R.layout.notification)
        remoteViews.setTextViewText(R.id.title,title)
        remoteViews.setTextViewText(R.id.message,message)
        remoteViews.setImageViewResource(R.id.logo,R.drawable.ic_launcher_background)
        return remoteViews

    }

    fun createNotification(title:String,message:String)
{
    val intent=Intent(this,MainActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    val pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT)

    var builder:NotificationCompat.Builder=NotificationCompat.Builder(applicationContext, channelId)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setAutoCancel(true)
        .setVibrate(longArrayOf(1000,1000,1000,1000))
        .setContentIntent(pendingIntent)
    builder=builder.setContent(getRemoteView(title,message))

    val notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.notify(0,builder.build())
}

    override fun onNewToken(token: String) {
        Log.e("tag","$token")
    }

}