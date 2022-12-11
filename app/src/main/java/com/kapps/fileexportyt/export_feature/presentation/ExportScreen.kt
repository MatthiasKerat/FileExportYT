package com.kapps.fileexportyt.export_feature.presentation

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.hilt.navigation.compose.hiltViewModel
import com.kapps.fileexportyt.R
import com.kapps.fileexportyt.ui.theme.gray
import com.kapps.fileexportyt.ui.theme.orange
import com.kapps.fileexportyt.ui.theme.white
import java.io.File

@Composable
fun ExportScreen(
    exportViewModel: ExportViewModel = hiltViewModel()
) {

    val fileExportState = exportViewModel.fileExportState
    val context = LocalContext.current

    LaunchedEffect(key1 = fileExportState){
        if(fileExportState.isShareDataClicked){
            val uri = FileProvider.getUriForFile(
                context,
                context.applicationContext.packageName+".provider",
                File(fileExportState.shareDataUri!!)
            )
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/csv"
            intent.putExtra(Intent.EXTRA_SUBJECT,"My Export Data")
            intent.putExtra(Intent.EXTRA_STREAM,uri)

            val chooser = Intent.createChooser(intent,"Share With")
            ContextCompat.startActivity(
                context,chooser,null
            )
            exportViewModel.onShareDataOpen()
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gray),
        contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ){
            Text(
                "Collected data amount: ${exportViewModel.collectedDataAmount}",
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold,
                color = white,
                textAlign = TextAlign.Center
            )
            Button(
                onClick = {
                    exportViewModel.generateExportFile()
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = orange,
                    contentColor = white,
                    disabledBackgroundColor = orange
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(10.dp),
                shape = CircleShape,
                enabled = !fileExportState.isSharedDataReady
            ){
                Text(
                    text = "Generate File",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            AnimatedVisibility(visible = fileExportState.isSharedDataReady) {
                IconButton(
                    onClick = {
                        exportViewModel.onShareDataClick()
                    }
                ){
                    Icon(
                        painterResource(id = R.drawable.export),
                        contentDescription = "export",
                        tint = orange,
                        modifier = Modifier
                            .size(120.dp)
                    )
                }
            }
        }
    }

    if (fileExportState.isGeneratingLoading){
        Dialog(
            onDismissRequest = {}
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                CircularProgressIndicator(
                    color = white
                )
                Text(
                    "Generating File (${fileExportState.generatingProgress}%) ...",
                    color = white,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }


}