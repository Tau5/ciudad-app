package com.example.p4_ciudad_pabloalonsosergiorodriguez.components

import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p4_ciudad_pabloalonsosergiorodriguez.MainViewModel
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.DataSource

enum class MainHostScreen {
    Main,
    SelectCity
}

@Composable
fun MainHost(
    mainViewModel: MainViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    val coroutineScope = rememberCoroutineScope()

    NavHost(
       navController,
       startDestination = "SelectCity", // TODO: Select based on if there is already a selected city or not saved,
       exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
       enterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
        popExitTransition = { fadeOut() }
   ) {
       composable(route = MainHostScreen.Main.name) {
            MainScreen(
                viewModel = mainViewModel,
                modifier = modifier,
                requestViewSelectCity = {
                    navController.navigate(MainHostScreen.SelectCity.name) {
                        popUpTo(MainHostScreen.Main.name) {
                            inclusive = true
                        }
                    }
                }
            )
       }
       composable(route = MainHostScreen.SelectCity.name) {
            var cityList = DataSource.cities.map{Pair(stringResource(it.name), it)}
            SelectionList(
                onSelect = {
                    mainViewModel.setCity(it)
                    navController.navigate(MainHostScreen.Main.name) {
                        popUpTo(MainHostScreen.SelectCity.name) {
                            inclusive = true
                        }
                    }
                },
                options = cityList,
                modifier = modifier
            )
       }
   }
}