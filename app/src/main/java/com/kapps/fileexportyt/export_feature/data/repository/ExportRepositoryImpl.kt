package com.kapps.fileexportyt.export_feature.data.repository

import com.kapps.fileexportyt.core.Resource
import com.kapps.fileexportyt.export_feature.data.converter.DataConverter
import com.kapps.fileexportyt.export_feature.data.file.FileWriter
import com.kapps.fileexportyt.export_feature.domain.model.ExportModel
import com.kapps.fileexportyt.export_feature.domain.model.PathInfo
import com.kapps.fileexportyt.export_feature.domain.repository.ExportRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExportRepositoryImpl @Inject constructor(
    private val fileWriter: FileWriter,
    private val dataConverter: DataConverter
): ExportRepository {
    override fun startExportData(
        exportList: List<ExportModel>
    ): Flow<Resource<PathInfo>> =
        dataConverter.convertSensorData(exportList).map { generateInfo ->
            when(generateInfo){
                is Resource.Success -> {
                    generateInfo.data.byteArray?.let {
                        when(val result = fileWriter.writeFile(it)){
                            is Resource.Success -> {
                                return@map Resource.Success(
                                    PathInfo(
                                        path = result.data,
                                        progressPercentage = 100
                                    )
                                )
                            }
                            is Resource.Loading -> {
                                return@map Resource.Error(errorMessage = "Unknown Error")
                            }
                            is Resource.Error -> {
                                return@map Resource.Error(errorMessage = result.errorMessage)
                            }
                        }
                    } ?: return@map Resource.Error(errorMessage = "Unkonwn error occured")
                }
                is Resource.Error ->{
                    return@map Resource.Error(errorMessage = generateInfo.errorMessage)
                }
                is Resource.Loading ->{
                    return@map Resource.Loading(
                        PathInfo(
                            progressPercentage = generateInfo.data?.progressPercentage ?: 0
                        )
                    )
                }
            }
        }.flowOn(Dispatchers.IO)
}