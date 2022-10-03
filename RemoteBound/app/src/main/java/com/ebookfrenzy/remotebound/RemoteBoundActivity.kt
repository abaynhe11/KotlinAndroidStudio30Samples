package com.ebookfrenzy.remotebound

import android.support.v7.app.AppCompatActivity
import android.content.ComponentName
import android.content.ServiceConnection
import android.content.Context
import android.content.Intent
import android.os.*
import android.view.View

class RemoteBoundActivity : AppCompatActivity() {

    var myService: Messenger? = null
    var isBound: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remote_bound)

        val intent = Intent(getApplicationContext(), RemoteService::class.java)
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)
    }

    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected(
                className: ComponentName,
                service: IBinder) {
            myService = Messenger(service)
            isBound = true
        }
        override fun onServiceDisconnected(
                className: ComponentName) {
            myService = null
            isBound = false
        }
    }
    fun sendMessage(view: View) {
        if (!isBound) return
        val msg = Message.obtain()
        val bundle = Bundle()
        bundle.putString("MyString", "Message Received")
        msg.data = bundle
        try {
            myService?.send(msg)
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }

}
