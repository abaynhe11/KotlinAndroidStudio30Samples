package com.ebookfrenzy.multiwindow

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
    }

    fun launchIntent(view: View) {
        val i = Intent(this, SecondActivity::class.java)

        i.addFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT or
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK or
                Intent.FLAG_ACTIVITY_NEW_TASK)

        startActivity(i)
    }
}
