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
        log<MRChapterMeta>("function called")
        if (imageURLs != null) {
            completion(imageURLs)
        } else {
            MRClient.getChapterImageUrls(oid) {response, _ ->
                // deduplicate image urls
                val cleaned = arrayListOf<String>()
                for(url in response?.data ?: arrayOf()) if(!cleaned.contains(url)) cleaned.add(url)
                completion(cleaned.toTypedArray())
                log<MRChapterMeta>("urls loaded")
            }
        }
    }

    val lastUpdatedDescription: String by lazy {
        dateFormat.format(lastUpdated)
    }

}