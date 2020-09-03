package com.example.userdefinedorcustombroadcast
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var myBroadcastReceiver:BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            sendB.setOnClickListener {
                var intent = Intent("com.example.Batch8")
                sendBroadcast(intent)
            }

            myBroadcastReceiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                Toast.makeText(context, "${intent?.action}", Toast.LENGTH_LONG).show()
            }
        }
        var intentFilter = IntentFilter()
        intentFilter.addAction("com.example.Batch8")

        registerReceiver(myBroadcastReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadcastReceiver)
    }
}