package com.explore.chenzerui.mr_dl.MRBackend

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder
import java.net.URL
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class MRSeriesMeta(@JsonProperty("oid") val oid: String,
                        @JsonProperty("name") val name: String,
                        @JsonProperty("author") val author: String,
                        @JsonProperty("completed") private val completed: Boolean=false,
                        @JsonProperty("last_update") private val lastUpdated: Date,
                        @JsonProperty("total_chapters") private val chaptersCount: Int,
                        @JsonProperty("description") val seriesDescription: String,
                        @JsonProperty("thumbnail") val thumbnailURL: String,
                        @JsonProperty("cover") val coverURL: String,
                        @JsonProperty("artworks") val artworkURLs: Array<String>,
                        @JsonProperty("alias") val alias: Array<String>,
                        @JsonProperty("chapters") val chapters: Array<MRChapterMeta>) {

    companion object {
        val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.US)
    }

    override fun equals(other: Any?): Boolean {
        return (other as? MRSeriesMeta)?.oid == oid
    }

    override fun hashCode(): Int {
        return oid.hashCode()
    }

    val stateDescription by lazy {
        "${if(completed) "Completed" else "Ongoing"}, $chaptersCount chapters"
    }

    val dateDescription: String by lazy {
        dateFormat.format(lastUpdated)
    }

}