package com.explore.chenzerui.mr_dl.MRImage

import com.bumptech.glide.load.Options
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import com.bumptech.glide.signature.ObjectKey
import java.net.URL
import java.nio.ByteBuffer


class MRIModelLoader: ModelLoader<String, ByteBuffer> {

    companion object {
        val Factory = object: ModelLoaderFactory<String, ByteBuffer> {
            override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<String, ByteBuffer> {
                return MRIModelLoader()
            }

            override fun teardown() {
            }
        }
    }

    override fun buildLoadData(model: String, width: Int, height: Int, options: Options): ModelLoader.LoadData<ByteBuffer>? {
        return ModelLoader.LoadData(ObjectKey(model), MRIDataFetcher(URL(model)))
    }

    override fun handles(model: String) = model.endsWith(".mri")

}