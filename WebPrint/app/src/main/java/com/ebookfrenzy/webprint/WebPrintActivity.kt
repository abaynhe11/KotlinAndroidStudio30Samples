package com.ebookfrenzy.webprint

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebResourceRequest
import android.print.PrintAttributes
import android.print.PrintManager
import android.content.Context

import kotlinx.android.synthetic.main.activity_web_print.*
import kotlinx.android.synthetic.main.content_web_print.*

class WebPrintActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_print)
        setSupportActionBar(toolbar)

        configureWebView()
    }

    private fun configureWebView() {
        myWebView?.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                    view: WebView, request: WebResourceRequest): Boolean {
                return super.shouldOverrideUrlLoading(
                        view, request)
            }
        }
        myWebView?.settings?.javaScriptEnabled = true
        myWebView?.loadUrl(
                "https://developer.android.com/google/index.html")
    }

    private fun createWebPrintJob(webView: WebView?) {
        val printManager = this
                .getSystemService(Context.PRINT_SERVICE) as PrintManager
        val printAdapter = webView?.createPrintDocumentAdapter("MyDocument")
        val jobName = getString(R.string.app_name) + " Print Test"
        printManager.print(jobName, printAdapter,
                PrintAttributes.Builder().build())
    }
    
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_web_print, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_print) {
            createWebPrintJob(myWebView)
        }
        return super.onOptionsItemSelected(item)
    }
}
