package com.ebookfrenzy.serviceexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

class ServiceExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_example)


    }

    fun buttonClick(view: View)
    {
        intent = Intent(this, MyService::class.java)
        startService(intent)
    }
}
