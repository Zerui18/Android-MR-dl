package com.explore.chenzerui.mr_dl.MRBackend

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.core.ResponseDeserializable

/**
 * Created by chenzerui on 7/4/18.
 */

data class MRAPIResponse<out DataType>(val data: DataType) {

    @JsonProperty("code")
    var statusCode: Int = 0

    class Deserializer<out DataType> : ResponseDeserializable<MRAPIResponse<DataType>> {
        override fun deserialize(content: String): MRAPIResponse<DataType> {
            return jacksonObjectMapper().readValue(content)
        }
    }

}