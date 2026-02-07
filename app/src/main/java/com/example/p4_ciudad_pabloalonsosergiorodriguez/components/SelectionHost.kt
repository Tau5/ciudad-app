package com.example.p4_ciudad_pabloalonsosergiorodriguez.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost

enum class SelectionScreen {
    CategorySelection,
    PlaceSelection,
    PlaceView
}

// NavHost for the selection of category, event and the place view.
// This is the one that appears above the map
@Composable
fun SelectionHost(
    navController: NavController,
    modifier: Modifier = Modifier
) {

}