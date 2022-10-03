package com.ebookfrenzy.localbound

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.ComponentName
import android.content.Context
import android.content.ServiceConnection
import android.os.IBinder
import android.content.Intent
import android.view.View

import kotlinx.android.synthetic.main.activity_local_bound.*

class LocalBoundActivity : AppCompatActivity() {

    var myService: BoundService? = null
    var isBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local_bound)

        val intent = Intent(this, BoundService::class.java)
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)
    }

    fun showTime(view: View) {
        val currentTime = myService?.getCurrentTime()
        myTextView.text = currentTime
    }

    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName,
                                        service: IBinder) {
            val binder = service as BoundService.MyLocalBinder
            myService = binder.getService()
            isBound = true
        }
        override fun onServiceDisconnected(name: ComponentName) {
            isBound = false
        }
    }
}
