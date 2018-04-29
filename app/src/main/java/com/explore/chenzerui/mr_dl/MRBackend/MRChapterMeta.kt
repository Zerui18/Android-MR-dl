package com.explore.chenzerui.mr_dl.MRBackend


//import android.arch.persistence.room.Entity
//import android.arch.persistence.room.ForeignKey
//import android.arch.persistence.room.ForeignKey.CASCADE
//import android.arch.persistence.room.Ignore
//import android.arch.persistence.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by chenzerui on 7/4/18.
 */

//@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class MRChapterMeta(@JsonProperty("oid") /*@PrimaryKey*/ var oid: String,
                         @JsonProperty("order") var order: Int,
                         @JsonProperty("name") var name: String,
                         @JsonProperty("updatedAt") var lastUpdated: Date) {

    companion object {
//        @Ignore
        val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.US)
    }

    @JsonIgnore
//    @ForeignKey(entity = MRSeriesMeta::class, parentColumns = ["oid"], childColumns = ["seriesOid"], onDelete = CASCADE)
    var seriesOid: String? = null

    @JsonIgnore
    var imageURLs: List<String>? = null

    fun fetchImageURLs(completion: (List<String>?)-> Unit) {
        if (imageURLs != null) {
            completion(imageURLs)
        } else {
            MRClient.getChapterImageUrls(oid) {response, _ ->
                // deduplicate image urls
                val cleaned = arrayListOf<String>()
                for(url in response?.data ?: arrayOf()) if(!cleaned.contains(url)) cleaned.add(url)
                completion(cleaned)
            }
        }
    }

//    @Ignore
    @JsonIgnore
    val lastUpdatedDescription: String = dateFormat.format(lastUpdated)

}