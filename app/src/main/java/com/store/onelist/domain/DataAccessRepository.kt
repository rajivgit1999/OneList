package com.store.onelist.domain

import com.store.onelist.data.model.ListItem

interface DataAccessRepository {

    suspend fun insertItem(item: ListItem)

    suspend fun getList(): List<ListItem>

    suspend fun deleteItem(item: ListItem)

    suspend fun deleteAllItems()

}