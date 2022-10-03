package com.ebookfrenzy.videoplayer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.util.Log
import android.app.PictureInPictureParams
import android.content.res.Configuration
import android.util.Rational
import android.view.View
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.widget.Toast
import android.app.PendingIntent
import android.app.RemoteAction
import android.graphics.drawable.Icon

import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : AppCompatActivity() {

    private val REQUEST_CODE = 101
    private var TAG = "VideoPlayer"
    private var mediaController: MediaController? = null
    private val receiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        configureVideoView()
    }

    fun enterPipMode(view: View) {
        val rational = Rational(videoView1.width,
                videoView1.height)
        val params = PictureInPictureParams.Builder()
                .setAspectRatio(rational)
                .build()
        pipButton.visibility = View.INVISIBLE
        videoView1.setMediaController(null)
        enterPictureInPictureMode(params)
    }

    private fun createPipAction() {

        val actions = ArrayList<RemoteAction>()
        val actionIntent = Intent("com.ebookfrenzy.videoplayer.VIDEO_INFO")
        val pendingIntent = PendingIntent.getBroadcast(this@VideoPlayerActivity,
                        REQUEST_CODE, actionIntent, 0)

        val icon = Icon.createWithResource(this, R.drawable.ic_info_24dp)
        val remoteAction = RemoteAction(icon, "Info", "Video Info", pendingIntent)
        actions.add(remoteAction)

        val params = PictureInPictureParams.Builder()
                .setActions(actions)
                .build()
        setPictureInPictureParams(params)
    }

    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean, newConfig: Configuration?) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)
        if (isInPictureInPictureMode) {
            val filter = IntentFilter()
            filter.addAction(
                    "com.ebookfrenzy.videoplayer.VIDEO_INFO")
            val receiver = object : BroadcastReceiver() {
                override fun onReceive(context: Context,
                                       intent: Intent) {
                    Toast.makeText(context,
                            "Favorite Home Movie Clips",
                            Toast.LENGTH_LONG).show()
                }
            }
            registerReceiver(receiver, filter)
            createPipAction()
        } else {
            pipButton.visibility = View.VISIBLE
            videoView1.setMediaController(mediaController)

            receiver?.let {
                unregisterReceiver(it)
            }
        }
    }

    private fun configureVideoView() {
        videoView1.setVideoPath(
                "http://www.ebookfrenzy.com/android_book/movie.mp4")

        mediaController = MediaController(this)
        mediaController?.setAnchorView(videoView1)
        videoView1.setMediaController(mediaController)

        videoView1.setOnPreparedListener { mp ->
            mp.isLooping = true
            Log.i(TAG, "Duration = " + videoView1.duration)
        }

        videoView1.start()
    }

}
