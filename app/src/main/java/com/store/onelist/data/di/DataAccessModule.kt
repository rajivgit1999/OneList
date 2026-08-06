package com.store.onelist.data.di

import com.store.onelist.data.DatabaseRepoImpl
import com.store.onelist.domain.DataAccessRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataAccessModule {

    @Binds
    abstract fun getDataAccessRepo(databaseRepoImpl: DatabaseRepoImpl): DataAccessRepository

}