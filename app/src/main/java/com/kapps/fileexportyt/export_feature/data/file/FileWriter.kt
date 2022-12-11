package com.kapps.fileexportyt.export_feature.data.file

import com.kapps.fileexportyt.core.Resource

interface FileWriter {

    suspend fun writeFile(byteArray: ByteArray):Resource<String>

    companion object{
        const val FILE_NAME = "FileExportApp"
    }

}