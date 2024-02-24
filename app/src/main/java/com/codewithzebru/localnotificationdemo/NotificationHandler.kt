package com.codewithzebru.localnotificationdemo

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import kotlin.random.Random

class NotificationHandler(private val context: Context) {
    private val notificationManager = context.getSystemService(NotificationManager::class.java)
    private val notificationChannelID = "notification_channel_id"

    // SIMPLE NOTIFICATION
    fun showSimpleNotification() {
        val notification = NotificationCompat.Builder(context, notificationChannelID)
            .setContentTitle("Simple Notification")
            .setContentText("Message or text with notification")
            .setSmallIcon(R.drawable.round_notifications_24)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(Random.nextInt(), notification)
    }

    // (EXPANDABLE) BIG TEXT NOTIFICATION
    fun showExpandedNotificationWithBigText() {
        val notification = NotificationCompat.Builder(context, notificationChannelID)
            .setContentTitle("Big-text Notification")
            .setContentText("See description")
            .setSmallIcon(R.drawable.round_notifications_24)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sit amet eros tempor, sagittis ipsum ac, facilisis ex. Morbi sit.")
            )
            .build()

        notificationManager.notify(Random.nextInt(), notification)
    }

    // NOTIFICATION WITH LARGE ICON
    fun showNotificationWithLargeIcon() {
        val notification = NotificationCompat.Builder(context, notificationChannelID)
            .setContentTitle("Large icon Notification")
            .setContentText("Image is on right")
            .setSmallIcon(R.drawable.round_notifications_24)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    context.resources,
                    R.drawable.code_with_zebru
                )
            )
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(Random.nextInt(), notification)
    }

    // (EXPANDABLE) NOTIFICATION WITH BIG PICTURE
    fun showExpandedNotificationWithBigPicture() {
        val notification = NotificationCompat.Builder(context, notificationChannelID)
            .setContentTitle("Big Picture Notification")
            .setContentText("Notification text")
            .setSmallIcon(R.drawable.round_notifications_24)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(context.bitmapFromResource(R.drawable.code_with_zebru))
            )
            .build()

        notificationManager.notify(Random.nextInt(), notification)
    }

    // (EXPANDABLE) NOTIFICATION WITH LONG TEXT, LARGE ICON AND BIG PICTURE
    fun showExpandedNotificationWithAllStyle() {
        val notification = NotificationCompat.Builder(context, notificationChannelID)
            .setContentTitle("Notification title")
            .setContentText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sit amet eros tempor, sagittis ipsum ac, facilisis ex. Morbi sit.")
            .setSmallIcon(R.drawable.round_notifications_24)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    context.resources,
                    R.drawable.code_with_zebru
                )
            )
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setAutoCancel(true)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sit amet eros tempor, sagittis ipsum ac, facilisis ex. Morbi sit.")
            )
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(context.bitmapFromResource(R.drawable.code_with_zebru))
            )
            .build()

        notificationManager.notify(Random.nextInt(), notification)
    }

    // ACTION NOTIFICATION
    fun showActionNotification() {
        // Intent to launch when the notification is clicked
        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_IMMUTABLE
        )

        // create a notification
        val notification = NotificationCompat.Builder(context, notificationChannelID)
            .setContentTitle("Notification title")
            .setContentText("Notification text")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)  // add the pendingIntent to notification
            .setAutoCancel(true)
            .build()

        notificationManager.notify(Random.nextInt(), notification)
    }

    // NOTIFICATION WITH ACTION BUTTON
    fun showNotificationWithActionButton() {
        // define the action button
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_MUTABLE or PendingIntent.FLAG_IMMUTABLE
        )

        // create a notification
        val notification = NotificationCompat.Builder(context, notificationChannelID)
            .setContentTitle("Notification with action button")
            .setContentText("Take your action")
            .setSmallIcon(R.drawable.round_notifications_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .addAction(
                // add the action button to notification
                NotificationCompat.Action(
                    R.drawable.round_notifications_24,
                    "Action",
                    pendingIntent
                )
            )
            .build()

        notificationManager.notify(Random.nextInt(), notification)
    }

    private fun Context.bitmapFromResource(
        @DrawableRes resId: Int
    ) = BitmapFactory.decodeResource(
        resources,
        resId
    )
}