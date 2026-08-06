package com.store.onelist.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.store.onelist.data.model.ListItem

@Dao
interface DbAccessInterface {

    @Insert
    suspend fun insertItem(item: ListItem)

    @Delete
    suspend fun removeItem(item: ListItem)

    @Query("Delete from StorageList")
    suspend fun removeAllItems()

    @Query("Select * from StorageList")
    suspend fun displayAll() : List<ListItem>

}