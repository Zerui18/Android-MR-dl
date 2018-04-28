package com.explore.chenzerui.mr_dl.MRImage

import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.data.DataFetcher
import com.explore.chenzerui.mr_dl.MRBackend.MRImageDecrypter.decrypt
import java.net.URL
import java.nio.ByteBuffer

class MRIDataFetcher(private val model: URL): DataFetcher<ByteBuffer> {

    override fun getDataClass() = ByteBuffer::class.java

    override fun cleanup() {
    }

    override fun getDataSource() = DataSource.LOCAL

    override fun cancel() {
    }

    override fun loadData(priority: Priority, callback: DataFetcher.DataCallback<in ByteBuffer>) {
        val bytes = model.readBytes()
        val data = decrypt(bytes)
        if(data != null) callback.onDataReady(ByteBuffer.wrap(data))
        else callback.onLoadFailed(Exception("MRI Decode Failed"))
    }
}