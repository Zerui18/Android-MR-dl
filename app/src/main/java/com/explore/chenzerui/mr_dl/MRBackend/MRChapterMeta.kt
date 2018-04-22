package com.explore.chenzerui.mr_dl.MRBackend


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by chenzerui on 7/4/18.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class MRChapterMeta(@JsonProperty("oid") val oid: String,
                         @JsonProperty("order") val order: Int,
                         @JsonProperty("name") val name: String,
                         @JsonProperty("updatedAt")
                         val lastUpdated: Date) {

    companion object {
        val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.US)
    }

    @Transient
    private var imageURLs: Array<String>? = null

    fun fetchImageURLs(completion: (Array<String>?)-> Unit) {
        if (imageURLs != null) {
            completion(imageURLs)
        } else {
            MRClient.getChapterImageUrls(oid) {response, _ ->
                completion(response?.data)
            }
        }
    }

    val lastUpdatedDescription by lazy {
        dateFormat.format(lastUpdated)
    }

}