package com.store.onelist.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.store.onelist.R
import com.store.onelist.data.model.ListItem
import com.store.onelist.ui.theme.OneListTheme
import com.store.onelist.ui.theme.Typography

@Composable
fun HomeScreen(storageViewModel: StorageViewModel?) {
    var text by remember { mutableStateOf("") }
    val list = storageViewModel?.itemList?.collectAsState()

    Column(
        modifier = Modifier
            .imePadding()
            .windowInsetsPadding(WindowInsets.systemBars)
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.size_20)),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(list?.value?.size?:0) { item ->
                Box(modifier = Modifier.height(dimensionResource(R.dimen.size_60))
                    .fillMaxWidth()
                    .border(color = Color.DarkGray, width = dimensionResource(R.dimen.size_4), shape = CircleShape),
                    contentAlignment = Alignment.CenterStart) {
                list?.value?.get(item)?.let {
                        Row(modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                modifier = Modifier.padding(start = dimensionResource(R.dimen.size_20)),
                                text = it.item,
                                style = Typography.bodyLarge
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            IconButton(
                                onClick = {
                                    storageViewModel.deleteItem(it)
                                },
                                modifier = Modifier.size(dimensionResource(R.dimen.size_40))
                                    .padding(end = dimensionResource(R.dimen.size_20))
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.outline_close_24),
                                    contentDescription = "Delete",
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.size_20)))
            }
        }
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Enter Element!")
            },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = dimensionResource(R.dimen.size_20)),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                modifier = Modifier.width(dimensionResource(R.dimen.size_150)),
                onClick = {
                    if(!text.isEmpty())
                    storageViewModel?.addItems(ListItem(
                        item = text,
                        quantity = 1,
                        id = 0,
                    ))
                    text = ""
                }
            ) {
                Text("Add")
            }
            Button(
                modifier = Modifier.width(dimensionResource(R.dimen.size_150)),
                onClick = {
                    storageViewModel?.deleteAllItems()
                    text = ""
                }
            ) {
                Text("Remove All")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    OneListTheme {
        HomeScreen(null)
    }
}