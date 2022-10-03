package com.ebookfrenzy.eventexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_event_example.*

class EventExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_example)

        button.setOnClickListener {
            statusText.text = "Button clicked"
        }

        button.setOnLongClickListener {
            statusText.text = "Long button click"
            false
        }
    }
}
