package com.explore.chenzerui.mr_dl.MRBackend

import android.util.Log

inline fun <reified Context>log(obj: Any) {
    Log.i("${Context::class}", obj.toString())
}