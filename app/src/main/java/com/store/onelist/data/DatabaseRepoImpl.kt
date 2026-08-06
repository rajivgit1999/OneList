package com.store.onelist.data

import android.util.Log
import com.store.onelist.data.db.StorageDb
import com.store.onelist.data.model.ListItem
import com.store.onelist.domain.DataAccessRepository
import javax.inject.Inject
import kotlin.collections.emptyList

class DatabaseRepoImpl @Inject constructor(private val storageDb: StorageDb): DataAccessRepository {

    override suspend fun insertItem(item: ListItem) {
        try {
            storageDb.getDao().insertItem(item)
            Log.d("OneList","Item added successfully!")
        }
        catch (e: Exception) {
            e.message?.let { Log.d("OneList",it) }
        }
    }

    override suspend fun getList(): List<ListItem> {
        try {
            return storageDb.getDao().displayAll()
        }
        catch (e: Exception) {
            e.message?.let { Log.d("OneList",it) }
        }
        return emptyList()
    }

    override suspend fun deleteItem(item: ListItem) {
        try {
            storageDb.getDao().removeItem(item)
            Log.d("OneList","Item removed successfully!")
        }
        catch (e: Exception) {
            e.message?.let { Log.d("OneList",it) }
        }
    }

    override suspend fun deleteAllItems() {
        try {
            storageDb.getDao().removeAllItems()
        }
        catch (e: Exception) {
            e.message?.let { Log.d("OneList",it) }
        }
    }

}