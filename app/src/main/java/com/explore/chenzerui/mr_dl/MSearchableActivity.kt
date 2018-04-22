package com.explore.chenzerui.mr_dl

import android.app.ListActivity
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import com.explore.chenzerui.mr_dl.MRBackend.MRClient
import com.explore.chenzerui.mr_dl.MRBackend.MRShortMeta
import java.lang.ref.WeakReference


class MSearchableActivity: ListActivity() {

    private val listAdapter by lazy { MSearchListAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listView.adapter= listAdapter

        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            performSearch(query)
        }

        listView.setOnItemClickListener { _, cell, _, _ ->
            val holder = cell.tag as MSearchListAdapter.CellHolder

            Statics.seriesMeta = holder.seriesMeta ?: return@setOnItemClickListener

            val intent = Intent(this, MInfoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun performSearch(query: String) {
        MRClient.quickSearch(query) { searchResponse, _ ->
            val seriesOids = searchResponse?.data?.get("series")

            if(seriesOids != null) {
                MRClient.getMetas(seriesOids.toTypedArray()) { metaResponse, _ ->
                    this.populateList(metaResponse?.data?.values?.toTypedArray())
                }
            }
            else {
                this.populateList(null)
            }
        }
    }

    private fun populateList(results: Array<MRShortMeta>?) {
        if(results == null) {
            listAdapter.items = arrayOf()
            return
        }
        listAdapter.items = results
        listAdapter.notifyDataSetInvalidated()
    }

}