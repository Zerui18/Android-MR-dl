package com.explore.chenzerui.mr_dl

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.explore.chenzerui.mr_dl.MRBackend.MRClient.getSeriesMeta
import com.explore.chenzerui.mr_dl.MRBackend.MRSeriesMeta
import com.explore.chenzerui.mr_dl.MRBackend.MRSeriesMetaResponse
import com.explore.chenzerui.mr_dl.MRBackend.MRShortMeta
import org.jetbrains.anko.find

class MSearchListAdapter(context: Context): ArrayAdapter<MRShortMeta>(context, 0) {

    var items by observing(arrayOf<MRShortMeta>(), didSet = { _ ->
        notifyDataSetInvalidated()
    })

    inner class CellHolder(view: View) {

        // Public Property
        var seriesMeta: MRSeriesMeta? = null

        // Private Properties
        private val thumbnailImageView: ImageView = view.find(R.id.thumbnailImageView)
        private val stateLabel: TextView = view.findViewById(R.id.stateLabel)
        private val dateLabel: TextView = view.findViewById(R.id.dateLabel)
        private val titleLabel: TextView = view.findViewById(R.id.titleLabel)
        private val descriptionLabel: TextView = view.findViewById(R.id.descriptionLabel)

        // Dynamic Property
        var shortMeta: MRShortMeta? by observing(null, didSet = { oldValue: MRShortMeta? ->

            val currentMeta = shortMeta ?: return@observing

            // ignore if the new shortMeta == current
            if(currentMeta == oldValue) return@observing

            // set currently available properties
            titleLabel.text = currentMeta.name
            // clear other properties
            stateLabel.text = ""
            dateLabel.text = ""
            descriptionLabel.text = ""

            // begin fetching extra details of the series
            getSeriesMeta(currentMeta.oid) { response: MRSeriesMetaResponse?, _ ->
                // return if the CellHolder has been assigned
                // a new shortMeta
                if (currentMeta != shortMeta) return@getSeriesMeta

                // ensure response has data
                val seriesMeta = response?.data ?: return@getSeriesMeta

                this.seriesMeta = seriesMeta

                // success, update UI
                stateLabel.text = seriesMeta.stateDescription
                dateLabel.text = seriesMeta.dateDescription
                descriptionLabel.text = seriesMeta.seriesDescription
            }

            // load thumbnail with placeholder, placed at the end to prevent blocking
            Glide.with(context).load(currentMeta.thumbnailURL)
                    .into(thumbnailImageView)
                    .onLoadStarted(context.getDrawable(R.drawable.ph_cover))

        })

    }

    private val inflater by lazy {
        LayoutInflater.from(context)
    }

    override fun isEmpty(): Boolean = items.isEmpty()

    override fun getCount(): Int = items.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: inflater.inflate(R.layout.cell_manga_search_result, parent, false)
        val cellHolder: CellHolder

        if(view.tag == null) {
            cellHolder = CellHolder(view)
            view.tag = cellHolder
        }
        else cellHolder = view.tag as CellHolder

        cellHolder.shortMeta = items[position]

        return view
    }
}