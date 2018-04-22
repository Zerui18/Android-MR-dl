package com.explore.chenzerui.mr_dl.MRBackend


import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by chenzerui on 7/4/18.
 */

data class MRAPIResponse<out DataType>(@JsonProperty("data") val data: DataType,
                                       @JsonProperty("code") val statusCode: Int = 0)