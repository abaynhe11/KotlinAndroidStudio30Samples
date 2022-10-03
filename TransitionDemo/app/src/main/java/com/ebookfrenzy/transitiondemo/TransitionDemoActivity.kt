package com.ebookfrenzy.transitiondemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import android.view.animation.BounceInterpolator
import android.transition.ChangeBounds

import kotlinx.android.synthetic.main.activity_transition_demo.*

class TransitionDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_demo)

        myLayout.setOnTouchListener { v: View, m: MotionEvent ->
            handleTouch()
            true
        }

    }

    private fun handleTouch() {

        val changeBounds = ChangeBounds()
        changeBounds.duration = 3000
        changeBounds.interpolator = BounceInterpolator()

        TransitionManager.beginDelayedTransition(myLayout, changeBounds)

        myButton.minWidth = 500
        myButton.minHeight = 350
        val set = ConstraintSet()
        set.connect(R.id.myButton, ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)
        set.connect(R.id.myButton, ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0)
        set.constrainWidth(R.id.myButton, ConstraintSet.WRAP_CONTENT)
        set.applyTo(myLayout)
    }
}
