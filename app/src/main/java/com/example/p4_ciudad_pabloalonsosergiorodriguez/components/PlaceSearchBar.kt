package com.example.p4_ciudad_pabloalonsosergiorodriguez.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.p4_ciudad_pabloalonsosergiorodriguez.MainViewModel
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.Place

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceSearchBar(
    onSearch: (String) -> Unit,
    searchResults: List<Pair<Place, String>>,
    modifier: Modifier = Modifier,
    onClickRandom: () -> Unit,
    onClickResult: (Place) -> Unit,
    viewModel: MainViewModel
) {
    ElevatedCard(modifier = modifier, elevation = CardDefaults.outlinedCardElevation(8.dp)) {
        Row(modifier = Modifier.weight(1f)) {
            SearchBar(
                expanded = viewModel.searchBarExpanded.value,
                onExpandedChange = { viewModel.searchBarExpanded.value = it },
                inputField = {
                    SearchBarDefaults.InputField(
                        query = viewModel.searchQueryState.value,
                        onQueryChange = { viewModel.searchQueryState.value = it },
                        expanded = viewModel.searchBarExpanded.value,
                        onExpandedChange = { viewModel.searchBarExpanded.value = it },
                        onSearch = onSearch
                    )
                },
            ) {

            }
            Spacer(Modifier.weight(1f))
            IconButton(onClick = onClickRandom, modifier = Modifier.fillMaxHeight()) {
                Icon(imageVector = Icons.Filled.Star, contentDescription = null, modifier = Modifier.fillMaxHeight())
            }
        }
    }
}
