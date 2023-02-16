package com.example.sanjeevanam

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.text.SimpleDateFormat
import java.util.*
import javax.mail.Authenticator
import javax.mail.Session


class RequestPage : AppCompatActivity() {

    private lateinit var showNotificationBtn: Button

    private companion object {

        private const val CHANNEL_ID = "channel01"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_page)

        showNotificationBtn = findViewById(R.id.createReqBtn)

        showNotificationBtn.setOnClickListener {


            showNotification()
        }
    }


    private fun showNotification(){

        createNotificationChannel()
        val date = Date()
        val notificationId = SimpleDateFormat(  "ddHHmmss", Locale.US).format (date).toInt()

        val intent = Intent( this, NearBy::class.java)
        intent.flags =  Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
       val mainIntent = PendingIntent.getActivity(this , 1 , intent , PendingIntent.FLAG_IMMUTABLE)



        val notificationBuilder = NotificationCompat.Builder(  this, "$CHANNEL_ID")

        notificationBuilder.setSmallIcon(R.drawable.slogo)

        notificationBuilder.setContentTitle("Request Status")

        notificationBuilder.setContentText("Request Sent Successfully !")

        notificationBuilder.priority = NotificationCompat.PRIORITY_DEFAULT

        notificationBuilder.setAutoCancel(true)

        notificationBuilder.setContentIntent(mainIntent)

        val notificationManagerCompat = NotificationManagerCompat.from(this)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            return
        }
        notificationManagerCompat.notify(notificationId , notificationBuilder.build())

    }

    private fun createNotificationChannel(){


        if (Build.VERSION. SDK_INT >= Build.VERSION_CODES.ECLAIR_0_1){
            val name: CharSequence = "MyNotification"
            val description = "My notification channel description"

            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val notificationChannel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel(CHANNEL_ID , name , importance)
            } else {
                TODO("VERSION.SDK_INT < O")
            }
            notificationChannel.description  = description
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
    }
}




}