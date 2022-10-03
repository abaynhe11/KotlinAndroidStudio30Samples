package com.ebookfrenzy.fabexample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.view.View

import kotlinx.android.synthetic.main.activity_fab_example.*
import kotlinx.android.synthetic.main.content_fab_example.*

import java.util.ArrayList
import java.text.SimpleDateFormat
import java.util.*

class FabExampleActivity : AppCompatActivity() {

    var listItems = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null

    var undoOnClickListener: View.OnClickListener = View.OnClickListener { view ->
        listItems.removeAt(listItems.size - 1)
        adapter?.notifyDataSetChanged()
        Snackbar.make(view, "Item removed", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fab_example)
        setSupportActionBar(toolbar)

        adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                listItems)
        listView.adapter = adapter

        fab.setOnClickListener { view ->
            addListItem()
            Snackbar.make(view, "Item added to list", Snackbar.LENGTH_LONG)
                    .setAction("Undo", undoOnClickListener).show()
        }
    }

    private fun addListItem() {

        val dateformat: SimpleDateFormat =
                SimpleDateFormat("HH:mm:ss MM/dd/yyyy", Locale.US)
        listItems.add(dateformat.format(Date()))
        adapter?.notifyDataSetChanged()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_fab_example, menu)
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
