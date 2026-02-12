package com.example.p4_ciudad_pabloalonsosergiorodriguez.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p4_ciudad_pabloalonsosergiorodriguez.MainViewModel
import org.maplibre.compose.map.MapOptions
import org.maplibre.compose.map.MaplibreMap
import org.maplibre.compose.map.OrnamentOptions
import org.maplibre.compose.style.BaseStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceSearchBar(
    onSearch: (String) -> Unit,
    onCancel: (Boolean) -> Unit,
    onClickRandom: () -> Unit,
    onClickChangeCity: () -> Unit,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    if (!viewModel.isSearching.value) {
        LocalFocusManager.current.clearFocus()
    }
    var isFocused by remember { mutableStateOf(false) }
    ElevatedCard(modifier = modifier, elevation = CardDefaults.outlinedCardElevation(8.dp)) {
        Row(modifier = Modifier.weight(1f)) {
            TextField(
                value = viewModel.searchQueryState.value,
                onValueChange = {
                    viewModel.searchQueryState.value = it
                    if (it.length > 0) {
                        onSearch(viewModel.searchQueryState.value)
                    } else {
                        onCancel(true)
                    }
                },
                singleLine = true,
                trailingIcon = {
                    AnimatedVisibility(viewModel.isSearching.value) {
                        IconButton(onClick = {
                            viewModel.searchQueryState.value = ""
                            onCancel(true)
                        }, modifier = Modifier.fillMaxHeight()) {
                            Icon(imageVector = Icons.Filled.Clear, contentDescription = null, modifier = Modifier.fillMaxHeight())
                        }
                    }
                },
                modifier = Modifier.weight(1f).fillMaxHeight().onFocusChanged({
                    isFocused = it.hasFocus
                }),
                placeholder = {
                    AnimatedVisibility(!isFocused) {
                        Icon(Icons.Filled.Search, contentDescription = "Buscar", modifier = Modifier.fillMaxHeight())
                    }
                }
            )
            IconButton(onClick = onClickChangeCity, modifier = Modifier.fillMaxHeight()) {
                Icon(imageVector = Icons.Filled.Place, contentDescription = null, modifier = Modifier.fillMaxHeight())
            }
            IconButton(onClick = onClickRandom, modifier = Modifier.fillMaxHeight()) {
                Icon(imageVector = Icons.Filled.Star, contentDescription = null, modifier = Modifier.fillMaxHeight())
            }
        }
    }
}

@Composable
@Preview
fun WhyStyleNoWorky() {
    PlaceSearchBar(
        onSearch = {},
        onCancel = {},
        onClickRandom = {},
        viewModel = viewModel(),
        modifier = Modifier.fillMaxWidth().height(70.dp),
        onClickChangeCity = {}
    )
}

@Composable
@Preview
fun WhyStyleNoWorkyReal() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (host, map) = createRefs()
        MaplibreMap(
            baseStyle = BaseStyle.Uri("https://tiles.openfreemap.org/styles/liberty"),
            modifier = Modifier.constrainAs(map) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            },
            options = MapOptions(ornamentOptions = OrnamentOptions(scaleBarAlignment = Alignment.BottomEnd)),
        )
        Column(
            modifier = Modifier.constrainAs(host) {
                top.linkTo(parent.top, margin = 8.dp)
                start.linkTo(parent.start, margin = 8.dp)
                end.linkTo(parent.end, margin = 8.dp)
                height = Dimension.value(300.dp)
                width = Dimension.fillToConstraints
            }
        ) {
            PlaceSearchBar(
                onSearch = {},
                onCancel = {},
                onClickRandom = {},
                viewModel = viewModel(),
                onClickChangeCity = {},
                modifier = Modifier.fillMaxWidth().height(70.dp)
            )
        }
    }
}