package com.explore.chenzerui.mr_dl.MRBackend

import kotlin.experimental.xor

/**
 * Created by chenzerui on 7/4/18.
 */
object MRImageDecrypter {

    fun decrypt(data: ByteArray): ByteArray? {

        val newData = ByteArray(data.size + 15)

        if(data[0].toInt() == 69) {

            val n = data.size + 7

            newData[0] = 82
            newData[1] = 73
            newData[2] = 70
            newData[3] = 70
            newData[7] = n.shr(24).toByte()
            newData[6] = n.shr(16).toByte()
            newData[5] = n.shr(8).toByte()
            newData[4] = n.toByte()
            newData[8] = 87
            newData[9] = 69
            newData[10] = 66
            newData[11] = 80
            newData[12] = 86
            newData[13] = 80
            newData[14] = 56
            for (i in 0 until data.size - 1) {
                newData[i + 15] = 101.toByte().xor(data[i])
            }

        }
        else return null

        return newData
    }
}