package com.store.onelist.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.store.onelist.data.dao.DbAccessInterface
import com.store.onelist.data.model.ListItem

@Database(entities = [ListItem::class], version = 1, exportSchema = false)
abstract class StorageDb: RoomDatabase() {
    abstract fun getDao(): DbAccessInterface
}