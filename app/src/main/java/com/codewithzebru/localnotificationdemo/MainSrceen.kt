package com.codewithzebru.localnotificationdemo

import android.Manifest
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen(context: Context) {
    val postNotificationPermission = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
    val notificationHandler = NotificationHandler(context)

    LaunchedEffect(key1 = true) {
        if (!postNotificationPermission.status.isGranted) {
            postNotificationPermission.launchPermissionRequest()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            notificationHandler.showSimpleNotification()
        }) { Text(text = "Simple") }

        Button(onClick = {
            notificationHandler.showExpandedNotificationWithBigText()
        }) { Text(text = "Big text") }

        Button(onClick = {
            notificationHandler.showNotificationWithLargeIcon()
        }) { Text(text = "Large icon") }

        Button(onClick = {
            notificationHandler.showExpandedNotificationWithBigPicture()
        }) { Text(text = "Big picture") }

        Button(onClick = {
            notificationHandler.showExpandedNotificationWithAllStyle()
        }) { Text(text = "All style") }

        Button(onClick = {
            notificationHandler.showActionNotification()
        }) { Text(text = "Action") }

        Button(onClick = {
            notificationHandler.showNotificationWithActionButton()
        }) { Text(text = "Action button") }
    }
}