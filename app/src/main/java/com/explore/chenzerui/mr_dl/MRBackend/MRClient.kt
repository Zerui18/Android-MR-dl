package com.explore.chenzerui.mr_dl.MRBackend

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.Request

object MRClient {

    private object APIs {
        const val quickSearchURL = "https://api.mangarockhd.com/query/web400/mrs_quick_search?country=Singapore"
        const val searchURL = "https://api.mangarockhd.com/query/web400/mrs_search?country=Singapore"
        const val getMetasURL = "https://api.mangarockhd.com/meta"
    }

    private fun <DataType> sendRequest(request: Request, completion: (MRAPIResponse<DataType>?, FuelError?)-> Unit) {
        request.responseObject(MRAPIResponse.Deserializer<DataType>()) {_, _, result ->
            if(result.component2() != null) {
                completion(null, result.component2())
            }
            else {
                completion(result.component1(), null)
            }
        }
    }

    fun quickSearch(query: String, completion: (MRQuickSearchResponse?, FuelError?) -> Unit) {
        val request = Fuel.post(APIs.quickSearchURL).body(query)

        sendRequest(request, completion)
    }

    fun completeSearch(query: String, completion: (MRCompleteSearchResponse?, FuelError?) -> Unit) {
        val body = jacksonObjectMapper().writeValueAsString(mapOf(
                "type"      to      "series",
                "query"     to      query
        ))
        val request = Fuel.post(APIs.searchURL).body(body)

        sendRequest(request, completion)
    }

    fun getMetas(oids: Array<String>, completion: (MRShortMetasResponse?, FuelError?) -> Unit) {
        val body = jacksonObjectMapper().writeValueAsString(oids)
        val request = Fuel.post(APIs.getMetasURL).body(body)

        sendRequest(request, completion)
    }

    fun getSerieMeta(oid: String, completion: (MRSerieMetaResponse?, FuelError?) -> Unit) {
        val request = Fuel.get("https://api.mangarockhd.com/query/web400/info?oid=$oid&last=0&country=Singapore")

        sendRequest(request, completion)
    }

    fun getChapterImageUrls(oid: String, completion: (MRChapterImageURLsResponse?, FuelError?) -> Unit) {
        val request = Fuel.get("https://api.mangarockhd.com/query/web400/pages?oid=$oid&country=Singapore")
        
        sendRequest(request, completion)
    }

    fun loadMRImage(url: String, completion: (Bitmap?) -> Void) {
        val result = Fuel.get(url).response {_, _, result ->
            val bitmap = result.component1()?.let {
                return@let MRImageDecrypter.decrypt(it)?.let{
                    BitmapFactory.decodeByteArray(it, 0, it.size)
                }
            }
            completion(bitmap)
        }
    }

}