package com.example.p4_ciudad_pabloalonsosergiorodriguez.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.p4_ciudad_pabloalonsosergiorodriguez.MainViewModel
import com.example.p4_ciudad_pabloalonsosergiorodriguez.ui.theme.P4_Ciudad_PabloAlonsoSergioRodriguezTheme
import org.maplibre.compose.map.MapOptions
import org.maplibre.compose.map.MaplibreMap
import org.maplibre.compose.map.OrnamentOptions
import org.maplibre.compose.style.BaseStyle
import org.maplibre.compose.style.StyleState
import org.maplibre.compose.style.rememberStyleState

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = viewModel(),
    modifier: Modifier = Modifier,
) {
    val cameraState = viewModel.mapCameraState
    Column(modifier = modifier) {
        PlaceSearchBar(
            onSearch = {},
            searchResults = listOf()
        )
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
                cameraState = cameraState.value
            )
            SelectionHost(
                navController,
                viewModel = viewModel,
                modifier = Modifier.constrainAs(host) {
                    top.linkTo(parent.top, margin = 8.dp)
                    start.linkTo(parent.start, margin = 8.dp)
                    end.linkTo(parent.end, margin = 8.dp)
                    height = Dimension.value(viewModel.mapPadding.calculateTopPadding())
                    width = Dimension.fillToConstraints
                }
            )
        }
    }
}