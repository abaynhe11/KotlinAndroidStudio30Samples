package com.ebookfrenzy.menuexample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.support.constraint.ConstraintLayout

import kotlinx.android.synthetic.main.activity_menu_example.*
import kotlinx.android.synthetic.main.content_menu_example.*

class MenuExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_example)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_menu_example, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_red -> {
                if (item.isChecked)
                    item.isChecked = false
                else
                    item.isChecked = true
                layoutView.setBackgroundColor(android.graphics.Color.RED)
                return true
            }
            R.id.menu_green -> {
                if (item.isChecked)
                    item.isChecked = false
                else
                    item.isChecked = true
                layoutView.setBackgroundColor(android.graphics.Color.GREEN)
                return true
            }
            R.id.menu_yellow -> {
                if (item.isChecked)
                    item.isChecked = false
                else
                    item.isChecked = true
                layoutView.setBackgroundColor(android.graphics.Color.YELLOW)
                return true
            }
            R.id.menu_blue -> {
                if (item.isChecked)
                    item.isChecked = false
                else
                    item.isChecked = true
                layoutView.setBackgroundColor(android.graphics.Color.BLUE)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
