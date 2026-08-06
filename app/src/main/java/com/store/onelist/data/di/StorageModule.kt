package com.store.onelist.data.di

import android.content.Context
import androidx.room.Room
import com.store.onelist.data.db.StorageDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class StorageModule {
    @Provides
    fun getRoomDatabase(@ApplicationContext context: Context): StorageDb {
        return Room.databaseBuilder(context,StorageDb::class.java,"OneListDb")
            .build()
    }
}