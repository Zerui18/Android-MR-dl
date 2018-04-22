package com.explore.chenzerui.mr_dl.MRBackend

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class MRShortMeta(@JsonProperty("oid") val oid: String,
                       @JsonProperty("name") val name: String,
                       @JsonProperty("thumbnail") val thumbnailURL: String)