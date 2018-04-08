package com.explore.chenzerui.mr_dl.MRBackend

import com.fasterxml.jackson.annotation.JsonProperty
import java.net.URL

data class MRShortMeta(val oid: String, val name: String,

                  @JsonProperty("thumbnail")
                  val thumbnailURL: URL)