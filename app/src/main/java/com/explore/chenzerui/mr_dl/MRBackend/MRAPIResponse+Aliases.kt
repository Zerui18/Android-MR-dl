package com.explore.chenzerui.mr_dl.MRBackend

import java.net.URL

/**
 * Created by chenzerui on 7/4/18.
 */

typealias MRQuickSearchResponse = MRAPIResponse<Map<String, Array<String>>>
typealias MRCompleteSearchResponse = MRAPIResponse<Array<String>>
typealias MRShortMetasResponse = MRAPIResponse<Map<String, MRShortMeta>>
typealias MRSerieMetaResponse = MRAPIResponse<MRSerieMeta>
typealias MRChapterImageURLsResponse = MRAPIResponse<Array<URL>>