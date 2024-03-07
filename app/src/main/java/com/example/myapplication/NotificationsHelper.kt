package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService

object NotificationsHelper {

    // 1 момент - notification channel
    // 2 момент - само окно notification
    private const val CHANNEL_ID = "ID"

    fun genNotificationChannel(context: Context) {
        var notificationManager = context.getSystemService(Service.NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Name",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationManager.createNotificationChannel(channel)
    }

    fun genNotificationMessage(context: Context) = NotificationCompat.Builder(context, CHANNEL_ID)
        .setContentTitle("Title")
        .setContentText("MediaPlayer is running!")
        .setSmallIcon(R.drawable.baseline_3mp_24)
        .build()
}