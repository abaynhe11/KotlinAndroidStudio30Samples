package com.ebookfrenzy.commongestures

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.widget.TextView
import android.view.MotionEvent
import android.support.v4.view.GestureDetectorCompat

import kotlinx.android.synthetic.main.activity_common_gestures.*

class CommonGesturesActivity : AppCompatActivity(),
GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    var gDetector: GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common_gestures)

        this.gDetector = GestureDetectorCompat(this, this)
        gDetector?.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        this.gDetector?.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onDown(event: MotionEvent): Boolean {
        gestureStatusText.text = "onDown"
        return true
    }
    override fun onFling(event1: MotionEvent, event2: MotionEvent,
                         velocityX: Float, velocityY: Float): Boolean {
        gestureStatusText.text = "onFling"
        return true
    }
    override fun onLongPress(event: MotionEvent) {
        gestureStatusText.text = "onLongPress"
    }
    override fun onScroll(e1: MotionEvent, e2: MotionEvent,
                          distanceX: Float, distanceY: Float): Boolean {
        gestureStatusText.text = "onScroll"
        return true
    }
    override fun onShowPress(event: MotionEvent) {
        gestureStatusText.text = "onShowPress"
    }
    override fun onSingleTapUp(event: MotionEvent): Boolean {
        gestureStatusText.text = "onSingleTapUp"
        return true
    }
    override fun onDoubleTap(event: MotionEvent): Boolean {
        gestureStatusText.text = "onDoubleTap"
        return true
    }
    override fun onDoubleTapEvent(event: MotionEvent): Boolean {
        gestureStatusText.text = "onDoubleTapEvent"
        return true
    }

    override fun onSingleTapConfirmed(event: MotionEvent): Boolean {
        gestureStatusText.text = "onSingleTapConfirmed"
        return true
    }
}
