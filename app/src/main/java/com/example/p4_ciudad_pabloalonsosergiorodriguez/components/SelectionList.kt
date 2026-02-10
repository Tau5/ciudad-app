package com.example.p4_ciudad_pabloalonsosergiorodriguez.components

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun <T>SelectionList(
    modifier: Modifier = Modifier,
    onSelect: (T) -> Unit,
    options: List<Pair<String, T>>
) {
    LazyColumn(modifier) {
       items(options) {
           SelectionButton(
               onClick = { onSelect(it.second) },
               text = it.first,
               modifier = Modifier.fillMaxWidth()
           )
           HorizontalDivider(color = MaterialTheme.colorScheme.primary)
       }
    }
}

@Composable
fun SelectionButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    FilledTonalButton(onClick, shape = RectangleShape, modifier = Modifier.height(48.dp)) {
        Row(modifier) {
            Text(text, Modifier.align(Alignment.CenterVertically))
            Spacer(Modifier.weight(1f))
            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
        }
    }
}

@Preview
@Composable
fun PreviewSelection() {
    SelectionButton("Ejemploo", {}, modifier = Modifier.width(200.dp).height(32.dp))
}
