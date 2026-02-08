package com.example.p4_ciudad_pabloalonsosergiorodriguez.components

import androidx.compose.runtime.Composable
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
   NavHost(
       navController,
       startDestination = "SelectCity" // TODO: Select based on if there is already a selected city or not saved
   ) {
       composable(route = MainHostScreen.Main.name) {

       }
       composable(route = MainHostScreen.SelectCity.name) {
            var cityList = DataSource.ciudades.map{Pair(stringResource(it.name), it)}
            SelectionList(
                onSelect = {
                    mainViewModel.setCity(it)
                    mainViewModel.tryChangeScreen(navController)
                },
                options = cityList,
                modifier = modifier
            )
       }
   }
}