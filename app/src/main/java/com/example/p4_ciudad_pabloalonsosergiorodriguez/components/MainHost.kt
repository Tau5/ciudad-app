package com.example.p4_ciudad_pabloalonsosergiorodriguez.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class MainHostScreen {
    Main,
    SelectCity
}

@Composable
fun MainHost(
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

       }
   }
}