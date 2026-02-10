package com.example.p4_ciudad_pabloalonsosergiorodriguez.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.example.p4_ciudad_pabloalonsosergiorodriguez.MainViewModel
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.Category
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.City
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.DataSource
import kotlinx.coroutines.launch

enum class SelectionScreen {
    CategorySelection,
    PlaceSelection,
    PlaceView
}

// NavHost for the selection of category, event and the place view.
// This is the one that appears above the map
@Composable
fun SelectionHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val coroutineScope = rememberCoroutineScope()
    var categoryList = Category.entries.map{Pair(stringResource(it.nombre), it)}
    NavHost(
        navController,
        startDestination = "CategorySelection",
        modifier = modifier
    ) {
        composable(route = SelectionScreen.CategorySelection.name) {
            coroutineScope.launch {
                viewModel.focusCity();
            }
            SelectionList(
                onSelect = {
                    viewModel.setCategory(it)
                    navController.navigate(SelectionScreen.PlaceSelection.name)
                },
                options = categoryList
            )
        }
        composable(route = SelectionScreen.PlaceSelection.name) {
            viewModel.selectedCity.value?.let { city: City ->
                val placeList = viewModel.getPlacesList()
                SelectionList(
                    onSelect = {
                        coroutineScope.launch {
                            viewModel.setPlace(it)
                        }
                    },
                    options = placeList
                )
            }

        }
    }
}