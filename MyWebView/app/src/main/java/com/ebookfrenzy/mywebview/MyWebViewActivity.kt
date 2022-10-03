package com.ebookfrenzy.mywebview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_web_view.*
import java.net.URL

class MyWebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_web_view)

        handleIntent()
    }

    private fun handleIntent() {
        val intent = this.intent
        val data = intent.data
        var url: URL? = null
        try {
            url = URL(data?.scheme,
                    data?.host,
                    data?.path)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        webView1.loadUrl(url?.toString())
    }
}
