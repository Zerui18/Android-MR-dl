package com.explore.chenzerui.mr_dl

import android.app.Fragment
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import com.explore.chenzerui.mr_dl.MRBackend.MRClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_manga_search.*
import java.util.*
import kotlin.concurrent.schedule

class MSearchFragment: Fragment() {

    var delayedSearch: TimerTask? = null
    var latestQuery = ""
    val resultsAdapter by lazy {
        MSearchListAdapter(activity, R.layout.cell_manga_search_result)
    }

    private val queryTextListener = object: SearchView.OnQueryTextListener {
        override fun onQueryTextChange(newText: String): Boolean {
            latestQuery = newText

            // cancel previous search and initiate new one
            delayedSearch?.cancel()

            if(newText.isBlank()) {
                resultsAdapter.items = arrayOf()
                return true
            }

            delayedSearch = Timer().schedule(300) {
                MRClient.completeSearch(newText) { response, _ ->
                    val oids = response?.data
                    if(newText != latestQuery || oids == null) return@completeSearch

                    MRClient.getMetas(oids) { metasResponse, _ ->
                        if(newText == latestQuery) resultsAdapter.items = metasResponse?.data?.values?.toTypedArray() ?: arrayOf()
                    }
                }
            }
            return true
        }

        override fun onQueryTextSubmit(query: String?) = true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_manga_search, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        menu!!.clear()
        inflater!!.inflate(R.menu.search, menu)
        val item = menu.findItem(R.id.search_item)
        val searchView = item.actionView as SearchView
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW or MenuItem.SHOW_AS_ACTION_IF_ROOM)
        item.actionView = searchView

        val manager = activity.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.setIconifiedByDefault(false)
        searchView.isIconified = false
        searchView.setSearchableInfo(manager.getSearchableInfo(activity.componentName))
        searchView.setOnQueryTextListener(queryTextListener)
    }


    override fun onResume() {
        super.onResume()
        activity.toolbar.title = "Search"

        resultsList.divider = null
        resultsList.adapter = resultsAdapter
        resultsList.setOnItemClickListener { _, cell, _, _ ->
            val holder = cell.tag as MSearchListAdapter.CellHolder
            Statics.seriesMeta = holder.seriesMeta ?: return@setOnItemClickListener

            val intent = Intent(activity, MInfoActivity::class.java)
            startActivity(intent)
        }
    }

}