package com.example.p4_ciudad_pabloalonsosergiorodriguez.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PlaceSearchBar(
    onSearch: (String) -> Unit,
    searchResults: List<String>,
    modifier: Modifier = Modifier,
    onClickRandom: () -> Unit
) {
    ElevatedCard(modifier = modifier, elevation = CardDefaults.outlinedCardElevation(8.dp)) {
        Row(modifier = Modifier.fillMaxHeight().padding(start = 8.dp, end = 8.dp)) {
            Spacer(Modifier.weight(1f))
            IconButton(onClick = onClickRandom, modifier = Modifier.fillMaxHeight()) {
                Icon(imageVector = Icons.Filled.Star, contentDescription = null, modifier = Modifier.fillMaxHeight())
            }
        }
    }
}
