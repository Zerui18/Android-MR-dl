package com.explore.chenzerui.mr_dl

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MDownloadsFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.fragment_manga_downloads, container, false)
    }

    override fun onResume() {
        super.onResume()
        activity.toolbar.title = "Downloads"
    }

}