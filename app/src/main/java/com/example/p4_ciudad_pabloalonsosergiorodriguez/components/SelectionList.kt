package com.example.p4_ciudad_pabloalonsosergiorodriguez.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <T>SelectionList(
    modifier: Modifier = Modifier,
    onSelect: (T) -> Unit,
    options: List<Pair<String, T>>
) {
    LazyColumn(modifier) {
       items(options) {
            Button(onClick = { onSelect(it.second) }) {
                Text(it.first)
            }
       }
    }
}