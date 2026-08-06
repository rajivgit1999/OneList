package com.store.onelist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.store.onelist.presentation.HomeScreen
import com.store.onelist.presentation.StorageViewModel
import com.store.onelist.ui.theme.OneListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val storageViewModel: StorageViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        storageViewModel.getItemList()
        enableEdgeToEdge()
        setContent {
            OneListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    HomeScreen(storageViewModel)
                }
            }
        }
    }
}