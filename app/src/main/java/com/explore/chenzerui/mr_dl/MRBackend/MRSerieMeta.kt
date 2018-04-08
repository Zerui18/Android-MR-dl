package com.explore.chenzerui.mr_dl.MRBackend

import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URL
import java.util.*

data class MRSerieMeta(val oid: String,

                  val name: String,

                  val author: String,

                  val completed: Boolean=false,

                  @JsonProperty("last_update")
                  val updated: Date,

                  @JsonProperty("total_chapters")
                  val chaptersCount: Int=0,

                  @JsonProperty("description")
                  val serieDescription: String,

                  @JsonProperty("thumbnail")
                  val thumbnailURL: URL,

                  @JsonProperty("cover")
                  val coverURL: URL,

                  @JsonProperty("artworks")
                  val artworkURLs: Array<URL>,

                  val alias: Array<String>)