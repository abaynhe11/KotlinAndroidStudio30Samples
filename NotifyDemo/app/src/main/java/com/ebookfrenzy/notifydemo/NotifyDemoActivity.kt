package com.ebookfrenzy.notifydemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.app.Notification
import android.view.View
import android.app.PendingIntent
import android.content.Intent
import android.graphics.drawable.Icon

class NotifyDemoActivity : AppCompatActivity() {

    private var notificationManager: NotificationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notify_demo)

        notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(
                "com.ebookfrenzy.notifydemo.news",
                "NotifyDemo News",
                "Example News Channel")
    }

    fun sendNotification(view: View) {

        val notificationID = 101
        val resultIntent = Intent(this, ResultActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
                this,
                0,
                resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )

        val channelID = "com.ebookfrenzy.notifydemo.news"

        val icon: Icon = Icon.createWithResource(this, android.R.drawable.ic_dialog_info)
        val action: Notification.Action =
                Notification.Action.Builder(icon, "Open", pendingIntent).build()

        val notification = Notification.Builder(this@NotifyDemoActivity,
                channelID)
                .setContentTitle("Example Notification")
                .setContentText("This is an example notification.")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setChannelId(channelID)
                .setContentIntent(pendingIntent)
                .setActions(action)
                .build()

        notificationManager?.notify(notificationID, notification)
    }

    private fun createNotificationChannel(id: String, name: String,
                                          description: String) {
        val importance = NotificationManager.IMPORTANCE_LOW
        val channel = NotificationChannel(id, name, importance)
        channel.description = description
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        channel.vibrationPattern =
                longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
        notificationManager?.createNotificationChannel(channel)
    }
}
