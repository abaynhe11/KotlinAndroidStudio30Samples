package com.ebookfrenzy.applinking

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import kotlinx.android.synthetic.main.activity_landmark.*


class LandmarkActivity : AppCompatActivity() {

    private var landmark: Landmark? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmark)

        // ATTENTION: This was auto-generated to handle app links.
        val appLinkIntent = intent
        val appLinkAction = appLinkIntent.action
        val appLinkData = appLinkIntent.data

        if (appLinkAction != null) {

            if (appLinkAction == "android.intent.action.VIEW") {

                val landmarkId = appLinkData?.lastPathSegment

                if (landmarkId != null) {
                    displayLandmark(landmarkId)
                }
            }
        } else {
            handleIntent(appLinkIntent)
        }
    }

    private fun handleIntent(intent: Intent) {

        val landmarkId = intent.getStringExtra(AppLinkingActivity.LANDMARK_ID)
        displayLandmark(landmarkId)

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }


    fun deleteLandmark(view: View) {

        val dbHandler = MyDBHandler(this, null, null, 1)

        if (landmark != null) {
            dbHandler.deleteLandmark(landmark?.id)
            titleText?.text = ""
            descriptionText?.text = ""
            deleteButton?.isEnabled = false
        }
    }

    private fun displayLandmark(landmarkId: String) {
        val dbHandler = MyDBHandler(this, null, null, 1)

        landmark = dbHandler.findLandmark(landmarkId)

        if (landmark != null) {

            if (landmark?.personal == 0) {
                deleteButton?.isEnabled = false
            } else {
                deleteButton?.isEnabled = true
            }

            titleText?.text = landmark!!.title
            descriptionText?.text = landmark!!.description
        } else {
            titleText?.text = "No Match Found"
        }
    }
}
