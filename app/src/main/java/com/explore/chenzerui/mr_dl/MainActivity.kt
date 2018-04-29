package com.explore.chenzerui.mr_dl

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var shared: MainActivity

        val fragments by lazy {
            arrayOf(MDownloadsFragment(), MSearchFragment())
        }
    }

    init {
        shared = this
    }

    var pageIndex: Int by observing(0, didSet = { lastIndex ->
        navView.menu.getItem(lastIndex).isChecked = false
        navView.menu.getItem(pageIndex).isChecked = true
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragments[pageIndex])
        transaction.commit()
    })


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBar()
        setupNavigation()
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar!!
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white)
    }

    private fun setupNavigation() {
        navView.setNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navigation_downloads->
                        pageIndex = 0
                R.id.navigation_search->
                        pageIndex = 1
            }
            layout.closeDrawers()
            true
        }

        // add downloads fragment as default
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragments[0])
        transaction.commit()
        navView.menu.getItem(0).isChecked = true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            android.R.id.home->
                layout.openDrawer(Gravity.START)
        }
        return true
    }

}
