package com.ebookfrenzy.customgestures

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.gesture.GestureLibraries
import android.gesture.GestureLibrary
import android.gesture.GestureOverlayView
import android.gesture.GestureOverlayView.OnGesturePerformedListener
import kotlinx.android.synthetic.main.activity_custom_gestures.*
import android.gesture.Prediction
import android.widget.Toast
import android.gesture.Gesture
import java.util.ArrayList

class CustomGesturesActivity : AppCompatActivity(), OnGesturePerformedListener {

    var gLibrary: GestureLibrary? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_gestures)

        gestureSetup()
    }

    private fun gestureSetup() {
        gLibrary = GestureLibraries.fromRawResource(this,
                R.raw.gestures)
        if (gLibrary?.load() == false) {
            finish()
        }

        gOverlay.addOnGesturePerformedListener(this)
    }

    override fun onGesturePerformed(overlay: GestureOverlayView,
                                    gesture: Gesture) {
        val predictions = gLibrary?.recognize(gesture)
        predictions?.let {

            if (it.size > 0 && it[0].score > 1.0) {
                val action = it[0].name
                Toast.makeText(this, action, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
