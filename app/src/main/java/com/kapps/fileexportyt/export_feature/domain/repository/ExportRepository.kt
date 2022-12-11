package com.kapps.fileexportyt.export_feature.domain.repository

import com.kapps.fileexportyt.core.Resource
import com.kapps.fileexportyt.export_feature.domain.model.ExportModel
import com.kapps.fileexportyt.export_feature.domain.model.PathInfo
import kotlinx.coroutines.flow.Flow

interface ExportRepository {

    fun startExportData(
        exportList:List<ExportModel>
    ): Flow<Resource<PathInfo>>

}