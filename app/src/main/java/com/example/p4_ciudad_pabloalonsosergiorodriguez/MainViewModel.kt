package com.example.p4_ciudad_pabloalonsosergiorodriguez

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.p4_ciudad_pabloalonsosergiorodriguez.components.MainHostScreen
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.City
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Optional

class MainViewModel : ViewModel() {
    var selectedCity: MutableState<City?> = mutableStateOf(null)
        private set

    var nextScreen: MainHostScreen? = null

    fun setCity(city: City) {
        selectedCity.value = city
        nextScreen = MainHostScreen.Main
    }

    fun tryChangeScreen(navHostController: NavHostController) {
        nextScreen?.let {
            navHostController.navigate(it.name)
            nextScreen = null
        }
    }
}
