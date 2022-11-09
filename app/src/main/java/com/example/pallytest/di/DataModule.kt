package com.example.pallytest.di

import com.example.pallytest.data.repositoryImpl.PallyRepositoryImpl
import com.example.pallytest.domain.repository.PallyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class DataModule {

    @Binds
    abstract fun dataRepository(countryRepositoryImpl: PallyRepositoryImpl): PallyRepository
}
