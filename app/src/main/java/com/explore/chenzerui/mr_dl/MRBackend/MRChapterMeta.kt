package com.explore.chenzerui.mr_dl.MRBackend


import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URL
import java.util.*

/**
 * Created by chenzerui on 7/4/18.
 */

data class MRChapterMeta(val oid: String, val order: Int, val name: String,

                         @JsonProperty("updatedAt")
                         val lastUpdated: Date) {

    private var imageURLs: Array<URL>? = null

    fun fetchImageURLs(completion: (Array<URL>?)-> Unit) {
        if (imageURLs != null) {
            completion(imageURLs)
        } else {
            MRClient.getChapterImageUrls(oid) {response, error ->
                completion(response?.data)
            }
        }
    }

}