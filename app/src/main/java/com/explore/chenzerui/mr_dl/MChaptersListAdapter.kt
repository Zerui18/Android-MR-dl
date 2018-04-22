package com.explore.chenzerui.mr_dl

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.explore.chenzerui.mr_dl.MRBackend.MRChapterMeta
import com.explore.chenzerui.mr_dl.MRBackend.MRSeriesMeta


class MChaptersListAdapter(context: Context, val seriesMeta: MRSeriesMeta): ArrayAdapter<MRChapterMeta>(context, seriesMeta.chapters.size) {


    private inner class CellHolder(view: View) {
        val dateLabel: TextView = view.findViewById(R.id.dateLabel)
        val titleLabel: TextView = view.findViewById(R.id.titleLabel)

        var chapterMeta: MRChapterMeta? by observing(null, didSet = { oldValue: MRChapterMeta? ->
            val currentMeta = chapterMeta ?: return@observing
            if(currentMeta == oldValue) return@observing

            dateLabel.text = currentMeta.lastUpdatedDescription
            titleLabel.text = currentMeta.name
            titleLabel.isSelected = true
        })
    }

    override fun isEmpty(): Boolean = seriesMeta.chapters.isEmpty()

    override fun getCount(): Int = seriesMeta.chapters.size

    private val inflater by lazy {
        LayoutInflater.from(context)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: inflater.inflate(R.layout.cell_manga_chapter_info, parent, false)

        val cellHolder: CellHolder

        if(view.tag == null) {
            cellHolder = CellHolder(view)
            view.tag = cellHolder
        }
        else cellHolder = view.tag as CellHolder

        cellHolder.chapterMeta = seriesMeta.chapters[position]

        return view
    }

}