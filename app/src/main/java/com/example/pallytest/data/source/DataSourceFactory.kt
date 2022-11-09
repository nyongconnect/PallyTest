package com.example.pallytest.data.source

import javax.inject.Inject

class DataSourceFactory @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) {
    fun remote(): RemoteDataSource = remoteDataSource
}
