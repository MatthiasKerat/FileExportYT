package com.kapps.fileexportyt.export_feature.di

import android.content.Context
import com.kapps.fileexportyt.export_feature.data.converter.DataConverter
import com.kapps.fileexportyt.export_feature.data.converter.csv.DataConverterCSV
import com.kapps.fileexportyt.export_feature.data.file.AndroidInternalStorageFileWriter
import com.kapps.fileexportyt.export_feature.data.file.FileWriter
import com.kapps.fileexportyt.export_feature.data.repository.ExportRepositoryImpl
import com.kapps.fileexportyt.export_feature.domain.repository.ExportRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ExportModule {

    @Provides
    @Singleton
    fun provideFileWrite(@ApplicationContext context:Context):FileWriter{
        return AndroidInternalStorageFileWriter(context)
    }

    @Provides
    @Singleton
    fun provideDataConverter():DataConverter{
        return DataConverterCSV()
    }

    @Provides
    @Singleton
    fun provideExportRepository(
        fileWriter: FileWriter,
        dataConverter:DataConverter
    ):ExportRepository{
        return ExportRepositoryImpl(fileWriter,dataConverter)
    }

}