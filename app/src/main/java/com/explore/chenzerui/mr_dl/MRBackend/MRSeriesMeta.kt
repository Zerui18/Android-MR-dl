package com.explore.chenzerui.mr_dl.MRBackend

//import android.arch.persistence.room.Entity
//import android.arch.persistence.room.Ignore
//import android.arch.persistence.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.text.SimpleDateFormat
import java.util.*

//@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class MRSeriesMeta(@JsonProperty("oid") /*@PrimaryKey*/ var oid: String,
                        @JsonProperty("name") var name: String,
                        @JsonProperty("author") var author: String,
                        @JsonProperty("completed") var completed: Boolean,
                        @JsonProperty("last_update") var lastUpdated: Date,
                        @JsonProperty("total_chapters") var chaptersCount: Int,
                        @JsonProperty("description") var seriesDescription: String,
                        @JsonProperty("thumbnail") var thumbnailURL: String,
                        @JsonProperty("cover") var coverURL: String,
//                        @JsonProperty("artworks") val artworkURLs: Array<String>,
//                        @JsonProperty("alias") val alias: Array<String>,
                        @JsonProperty("chapters") /*@Ignore*/ var chapters: Array<MRChapterMeta>) {

//    constructor(): this("", "", "", false, Date(), 0, "", "", "", arrayOf())

    companion object {
//        @Ignore
        val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.US)
    }

    override fun equals(other: Any?): Boolean {
        return (other as? MRSeriesMeta)?.oid == oid
    }

    override fun hashCode(): Int {
        return oid.hashCode()
    }

//    @Ignore
    @JsonIgnore
    val stateDescription = "${if(completed) "Completed" else "Ongoing"}, $chaptersCount chapters"

//    @Ignore
    @JsonIgnore
    val dateDescription: String = dateFormat.format(lastUpdated)

}