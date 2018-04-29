package com.explore.chenzerui.mr_dl

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_manga_page.*

@SuppressLint("ValidFragment")
class MPageFragment(): Fragment() {

    private var imageURL: String? = null
    private var onClick: ((View)->Unit)? = null

    constructor(imageURL: String?, onClick: ((View)->Unit)?): this() {
        this.imageURL = imageURL
        this.onClick = onClick
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_manga_page, container, false)
    }

    override fun onResume() {
        super.onResume()
        if (onClick != null) imageView.setOnClickListener(onClick)
        val url = imageURL ?: return
        Glide.with(this).load(url).into(imageView)
                .onLoadStarted(activity!!.getDrawable(R.drawable.ph_cover))
    }

}