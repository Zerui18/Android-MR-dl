package com.explore.chenzerui.mr_dl

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_manga_info.*


class MInfoActivity: Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga_info)
        updateDisplay()

        readButton.setOnClickListener { _ ->
            val intent = Intent(this, MChaptersListActivity::class.java)
            startActivity(intent)
        }
    }

    // update UI components with Statics.seriesMeta
    private fun updateDisplay() {
        val meta = Statics.seriesMeta!!

        titleLabel.text = meta.name
        authorLabel.text = meta.author
        stateLabel.text = meta.stateDescription
        dateLabel.text = meta.dateDescription
        descriptionLabel.text = meta.seriesDescription

        Glide.with(this).load(meta.coverURL).into(backgroundImage)
        Glide.with(this).load(meta.thumbnailURL).into(thumbnailImageView)
    }

}