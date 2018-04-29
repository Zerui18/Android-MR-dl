package com.explore.chenzerui.mr_dl

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.explore.chenzerui.mr_dl.MRBackend.MRChapterMeta
import kotlinx.android.synthetic.main.activity_manga_viewer.*

@SuppressLint("SetTextI18n")
class MViewerActivity: AppCompatActivity() {

    private var chapterMeta: MRChapterMeta by observing(Statics.chapterMeta!!, didSet = { lastChapter ->
        toolbar.title = chapterMeta.name
        overlay.visibility = View.VISIBLE
        pageButton.text = "??"
        pageButton.isClickable = false
        chapterMeta.fetchImageURLs { imageURLs ->
            if(imageURLs != null) {
                this.imageURLs = imageURLs.reversedArray()
                pageButton.text = "1/${imageURLs.size}"
                overlay.visibility = View.INVISIBLE
                pageButton.isClickable = true
                viewPager.adapter!!.notifyDataSetChanged()
                if(lastChapter.order <= chapterMeta.order) viewPager.setCurrentItem(imageURLs.size, false)
                else viewPager.currentItem = 1
            }
            else {
                this.imageURLs = arrayOf()
                overlay.text = "Loading Failed\nYour internet connection appears to be offline."
            }
        }
    })

    private var imageURLs: Array<String> by observing(arrayOf(), didSet = {_ ->
        viewPager.adapter!!.notifyDataSetChanged()
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga_viewer)
        setSupportActionBar(toolbar)
        setupViewPager()
        setupGestures()

        chapterMeta = Statics.chapterMeta!!
    }

    private fun setupViewPager() {
        viewPager.adapter = Adapter()
        viewPager.offscreenPageLimit = 5
        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                val seriesMeta = Statics.seriesMeta!!
                when (position) {
                    0 -> {
                        // go to next chapter
                        if(chapterMeta.order < seriesMeta.chapters.size) chapterMeta = seriesMeta.chapters[chapterMeta.order+1]
                    }
                    imageURLs.size+1 -> {
                        // got to prev chapter
                        if(chapterMeta.order > 0) chapterMeta = seriesMeta.chapters[chapterMeta.order-1]
                    }
                    else -> pageButton.text = "${imageURLs.size+1-position}/${imageURLs.size}"
                }
            }
        })
    }

    private fun setupGestures() {
        pageButton.setOnClickListener { _ ->

        }
    }

    private inner class Adapter: FragmentStatePagerAdapter(supportFragmentManager) {
        override fun getCount(): Int = imageURLs.size + 2
        override fun getItem(position: Int): Fragment {
            if(imageURLs.isEmpty() || position == 0 || position == imageURLs.size+1) return MPageFragment(null, null)
            return MPageFragment(imageURLs[position-1], {_ ->
                if(supportActionBar!!.isShowing) supportActionBar!!.hide()
                else supportActionBar!!.show()
            })
        }
    }

}

