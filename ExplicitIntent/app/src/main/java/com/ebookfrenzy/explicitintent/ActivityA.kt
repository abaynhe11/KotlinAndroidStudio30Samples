package com.ebookfrenzy.explicitintent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent

import kotlinx.android.synthetic.main.activity_a.*

class ActivityA : AppCompatActivity() {

    private val request_code = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
    }

    fun onClick(view: View) {
        val i = Intent(this, ActivityB::class.java)
        val myString = editText.text.toString()
        i.putExtra("qString", myString)
        startActivityForResult(i, request_code)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if ((requestCode == request_code) &&
                (resultCode == RESULT_OK)) {
            if (data.hasExtra("returnData")) {
                val returnString = data.extras.getString("returnData")
                textView1.text = returnString
            }
        }
    }
}
