package com.ebookfrenzy.tablayoutdemo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.support.design.widget.TabLayout

import kotlinx.android.synthetic.main.activity_tab_layout_demo.*

class TabLayoutDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout_demo)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        configureTabLayout()
    }

    private fun configureTabLayout() {
        /*
        tab_layout.addTab(tab_layout.newTab().setText("Tab 1 Item"))
        tab_layout.addTab(tab_layout.newTab().setText("Tab 2 Item"))
        tab_layout.addTab(tab_layout.newTab().setText("Tab 3 Item"))
        tab_layout.addTab(tab_layout.newTab().setText("Tab 4 Item"))
        */

        tab_layout.addTab(tab_layout.newTab().setIcon(
                android.R.drawable.ic_dialog_email))
        tab_layout.addTab(tab_layout.newTab().setIcon(
                android.R.drawable.ic_dialog_dialer))
        tab_layout.addTab(tab_layout.newTab().setIcon(
                android.R.drawable.ic_dialog_map))
        tab_layout.addTab(tab_layout.newTab().setIcon(
                android.R.drawable.ic_dialog_info))
        
        val adapter = TabPagerAdapter(supportFragmentManager,
                tab_layout.tabCount)
        pager.adapter = adapter
        pager.addOnPageChangeListener(
                TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout.addOnTabSelectedListener(object : TabLayout.
        OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_tab_layout_demo, menu)
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
