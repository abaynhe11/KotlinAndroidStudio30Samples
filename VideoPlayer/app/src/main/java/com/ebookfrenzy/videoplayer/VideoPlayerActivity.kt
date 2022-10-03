package com.ebookfrenzy.videoplayer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.util.Log

import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : AppCompatActivity() {

    private var TAG = "VideoPlayer"
    private var mediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        configureVideoView()
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
