package com.example.pallytest.di

import com.example.pallytest.data.source.RemoteDataSource
import com.example.pallytest.remote.service.ApiService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    @Binds
    @Singleton
    abstract fun remoteDataSource(remoteDataSourceImpl: ApiService): RemoteDataSource
}
