package com.store.onelist.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StorageList")
data class ListItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val item: String,
    val quantity: Int = 0
)