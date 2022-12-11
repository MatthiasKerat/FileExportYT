package com.kapps.fileexportyt.export_feature.data.converter

import com.kapps.fileexportyt.core.Resource
import com.kapps.fileexportyt.export_feature.domain.model.ExportModel
import kotlinx.coroutines.flow.Flow

interface DataConverter {

    fun convertSensorData(
        exportDataList:List<ExportModel>
    ): Flow<Resource<GenerateInfo>>

}