package com.ebookfrenzy.scenetransitions

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.view.View
import android.transition.TransitionManager
import android.transition.TransitionInflater
import android.transition.Transition

import kotlinx.android.synthetic.main.activity_scene_transitions.*

class SceneTransitionsActivity : AppCompatActivity() {

    var scene1: Scene? = null
    var scene2: Scene? = null
    var transitionMgr: Transition? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_transitions)

        transitionMgr = TransitionInflater.from(this)
                .inflateTransition(R.transition.transition)

        scene1 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene1_layout, this)

        scene2 = Scene.getSceneForLayout(rootContainer,
                R.layout.scene2_layout, this)

        scene1?.enter()
    }

    fun goToScene2(view: View) {
        TransitionManager.go(scene2, transitionMgr)
    }

    fun goToScene1(view: View) {
        TransitionManager.go(scene1, transitionMgr)
    }
}
