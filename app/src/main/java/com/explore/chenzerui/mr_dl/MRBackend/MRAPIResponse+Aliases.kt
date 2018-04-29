package com.explore.chenzerui.mr_dl.MRBackend


/**
 * Created by chenzerui on 7/4/18.
 */

typealias MRQuickSearchResponse = MRAPIResponse<Map<String, ArrayList<String>>>
typealias MRCompleteSearchResponse = MRAPIResponse<Array<String>>
typealias MRShortMetasResponse = MRAPIResponse<Map<String, MRShortMeta>>
typealias MRSeriesMetaResponse = MRAPIResponse<MRSeriesMeta>
typealias MRChapterImageURLsResponse = MRAPIResponse<Array<String>>
