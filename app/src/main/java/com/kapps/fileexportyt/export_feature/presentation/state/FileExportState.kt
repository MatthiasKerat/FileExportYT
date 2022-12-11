package com.kapps.fileexportyt.export_feature.presentation.state

data class FileExportState(
    val isGeneratingLoading:Boolean = false,
    val isShareDataClicked:Boolean = false,
    val isSharedDataReady:Boolean = false,
    val shareDataUri:String? = null,
    val failedGenerating:Boolean = false,
    val generatingProgress:Int = 0
)
