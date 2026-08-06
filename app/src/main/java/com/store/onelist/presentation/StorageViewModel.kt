package com.store.onelist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.store.onelist.data.model.ListItem
import com.store.onelist.domain.DataAccessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StorageViewModel @Inject constructor(private val dataAccessRepository: DataAccessRepository): ViewModel() {

    private val _itemList = MutableStateFlow<List<ListItem>>(emptyList())
    val itemList: StateFlow<List<ListItem>> = _itemList
    fun addItems(item: ListItem) {
        viewModelScope.launch{
            dataAccessRepository.insertItem(item)
            _itemList.value = dataAccessRepository.getList()
        }
    }

    fun getItemList(): List<ListItem> {
        viewModelScope.launch {
            _itemList.value = dataAccessRepository.getList()
        }
        return itemList.value
    }

    fun deleteItem(item: ListItem) {
        viewModelScope.launch {
            dataAccessRepository.deleteItem(item)
            _itemList.value = dataAccessRepository.getList()
        }
    }

    fun deleteAllItems() {
        viewModelScope.launch {
            dataAccessRepository.deleteAllItems()
            _itemList.value = dataAccessRepository.getList()
        }
    }

}