package com.ebookfrenzy.serviceexample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.os.AsyncTask

class MyService : Service() {

    private val TAG = "ServiceExample"

    override fun onCreate() {
        Log.i(TAG, "Service onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val task = SrvTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, startId)
        return Service.START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        Log.i(TAG, "Service onBind")
        return null
    }

    override fun onDestroy() {
        Log.i(TAG, "Service onDestroy")
    }

    private inner class SrvTask : AsyncTask<Int, Int, String>() {
        override fun onPreExecute() {
        }
        override fun doInBackground(vararg params: Int?): String {
            val startId = params[0]
            var i = 0
            while (i <= 20) {
                try {
                    Thread.sleep(10000)
                    publishProgress(startId)
                    i++
                }
                catch (e: Exception) {
                    return(e.localizedMessage)
                }
            }
            return "Service complete $startId"
        }
        override fun onProgressUpdate(vararg values: Int?) {
            super.onProgressUpdate(*values)
            val counter = values.get(0)
            Log.i(TAG, "Service Running $counter")
        }
        override fun onPostExecute(result: String) {
            Log.i(TAG, result)

        }
    }

}
