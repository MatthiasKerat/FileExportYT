package com.kapps.fileexportyt.export_feature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kapps.fileexportyt.core.Resource
import com.kapps.fileexportyt.export_feature.domain.model.ExportModel
import com.kapps.fileexportyt.export_feature.domain.repository.ExportRepository
import com.kapps.fileexportyt.export_feature.presentation.state.FileExportState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ExportViewModel @Inject constructor(
    private val exportRepository: ExportRepository
):ViewModel() {

    private var exportList = mutableListOf<ExportModel>()

    var collectedDataAmount by mutableStateOf(0)
        private set

    var fileExportState by mutableStateOf(FileExportState())
        private set

    private var collectingJob: Job? = null
    init {
        collectingJob = viewModelScope.launch {
            while (true){
                delay(2)
                collectedDataAmount += 160
                exportList.addAll(
                    listOf(
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                        ExportModel(Random.nextFloat()*10000,System.currentTimeMillis()),
                    )
                )
            }
        }
    }

    fun generateExportFile(){
        collectingJob?.cancel()
        fileExportState = fileExportState.copy(isGeneratingLoading = true)
        exportRepository.startExportData(
            exportList.toList()
        ).onEach { pathInfo ->
            when(pathInfo){
                is Resource.Success -> {
                    fileExportState = fileExportState.copy(
                        isSharedDataReady = true,
                        isGeneratingLoading = false,
                        shareDataUri = pathInfo.data.path,
                        generatingProgress = 100
                    )
                }
                is Resource.Loading ->{
                    pathInfo.data?.let {
                        fileExportState = fileExportState.copy(
                            generatingProgress = pathInfo.data.progressPercentage
                        )
                    }
                }
                is Resource.Error -> {
                    fileExportState = fileExportState.copy(
                        failedGenerating = true,
                        isGeneratingLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onShareDataClick(){
        fileExportState = fileExportState.copy(isShareDataClicked = true)
    }

    fun onShareDataOpen(){
        fileExportState = fileExportState.copy(isShareDataClicked = false)
    }

}