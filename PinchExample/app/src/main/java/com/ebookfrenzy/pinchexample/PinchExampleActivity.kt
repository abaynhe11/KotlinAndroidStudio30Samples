package com.ebookfrenzy.pinchexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
import kotlinx.android.synthetic.main.activity_pinch_example.*

class PinchExampleActivity : AppCompatActivity() {

    var scaleGestureDetector: ScaleGestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pinch_example)

        scaleGestureDetector = ScaleGestureDetector(this,
                MyOnScaleGestureListener())
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        scaleGestureDetector?.onTouchEvent(event)
        return true
    }

    inner class MyOnScaleGestureListener : SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            val scaleFactor = detector.scaleFactor
            if (scaleFactor > 1) {
                myTextView.text = "Zooming Out"
            } else {
                myTextView.text = "Zooming In"
            }
            return true
        }

        override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
            return true
        }

        override fun onScaleEnd(detector: ScaleGestureDetector) {
        }
    }
}
