package com.ebookfrenzy.cameraapp

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.PackageManager
import android.provider.MediaStore
import android.content.Intent
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_camera_app.*

class CameraAppActivity : AppCompatActivity() {

    private val VIDEO_CAPTURE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_app)

        recordButton.isEnabled = hasCamera()
    }

    private fun hasCamera(): Boolean {
        return packageManager.hasSystemFeature(
                PackageManager.FEATURE_CAMERA_ANY)
    }

    fun startRecording(view: View) {
        val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        startActivityForResult(intent, VIDEO_CAPTURE)
    }

    override fun onActivityResult(requestCode: Int,
                                  resultCode: Int, data: Intent) {
        val videoUri = data.data
        if (requestCode == VIDEO_CAPTURE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Video saved to:\n"
                        + videoUri, Toast.LENGTH_LONG).show()
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Video recording cancelled.",
                        Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Failed to record video",
                        Toast.LENGTH_LONG).show()
            }
        }
    }
}
