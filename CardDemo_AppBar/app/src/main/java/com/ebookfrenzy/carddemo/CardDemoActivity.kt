package com.ebookfrenzy.carddemo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.graphics.Color

import kotlinx.android.synthetic.main.activity_card_demo.*

class CardDemoActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_demo)
        setSupportActionBar(toolbar)

        collapsing_toolbar.title = "My Toolbar Title"
        collapsing_toolbar.setContentScrimColor(Color.GREEN)

        layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        recycler_view.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_card_demo, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
