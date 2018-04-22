package com.explore.chenzerui.mr_dl

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_chapters_list.*

class MChaptersListActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapters_list)

        val seriesMeta = Statics.seriesMeta!!
        toolbar.title = "${seriesMeta.chapters.size} Chapters"

        chaptersList.adapter = MChaptersListAdapter(this, seriesMeta)
        chaptersList.setOnItemClickListener { _, _, position, _ ->
            Statics.chapterMeta = seriesMeta.chapters[position]
            val intent = Intent(this, )
        }
    }

}