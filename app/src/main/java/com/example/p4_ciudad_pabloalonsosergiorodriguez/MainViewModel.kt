package com.example.p4_ciudad_pabloalonsosergiorodriguez

import android.graphics.Camera
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.p4_ciudad_pabloalonsosergiorodriguez.components.MainHostScreen
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.Category
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.City
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.DataSource
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.Place
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import org.maplibre.compose.camera.CameraPosition
import org.maplibre.compose.camera.CameraState
import java.util.Optional
import kotlin.collections.listOf
import kotlin.time.Duration.Companion.milliseconds

class MainViewModel : ViewModel() {
    var selectedCity: MutableState<City?> = mutableStateOf(null)
        private set

    var selectedCategory: MutableState<Category?> = mutableStateOf(null)
        private set

    var selectedPlace: MutableState<Place?> = mutableStateOf(null)
        private set

    var mapCameraState: MutableState<CameraState> = mutableStateOf(CameraState(
        CameraPosition()
    ))

    var nextScreen: MainHostScreen? = null

    fun setCity(city: City) {
        selectedCity.value = city
        mapCameraState.value.position = CameraPosition(target = city.position, zoom = 8.0)
    }

    suspend fun setPlace(place: Place) {
        selectedPlace.value = place
        mapCameraState.value.animateTo(
            finalPosition = CameraPosition(target = place.position, zoom = 18.0, tilt = 30.0),
            duration = 1000.milliseconds
        )
    }

    suspend fun focusCity() {
        selectedCity.value?.let {
            mapCameraState.value.animateTo(
                finalPosition = CameraPosition(target = it.position, zoom = 8.0),
                duration = 1000.milliseconds
            )
        }
    }

    fun setCategory(category: Category) {
        selectedCategory.value = category
    }

    @Composable
    fun getPlacesList(): List<Pair<String, Place>> {
        return selectedCity.value?.let { city ->
            city.places
                .filter { it.category == selectedCategory.value }
                .map{ Pair(stringResource(it.name), it) }
        } ?: run {
            listOf()
        }
    }

    fun tryChangeScreen(navHostController: NavHostController) {
        nextScreen?.let {
            navHostController.navigate(it.name)
            nextScreen = null
        }
    }
}
