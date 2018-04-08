package com.explore.chenzerui.mr_dl

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.explore.chenzerui.mr_dl.MRBackend.MRClient
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {

    companion object {
        var shared: MainActivity? = null
    }

    init {
        shared = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doAsync {
            val bitmap = MRClient.loadMRImage("https://f01.mrcdn.info/file/mrfiles/g/8/6/5/T7.eOn3_VRp.mri")
            val activity = this.weakRef.get()!!
            runOnUiThread {
                activity.tImageView.setImageBitmap(bitmap)
            }
        }
    }

    fun log(body: String) {
        Log.i("MainActivity", body)
    }

}
