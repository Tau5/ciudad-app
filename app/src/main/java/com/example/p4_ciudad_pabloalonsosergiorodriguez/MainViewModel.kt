package com.example.p4_ciudad_pabloalonsosergiorodriguez

import android.graphics.Camera
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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

    var mapPadding: MutableState<PaddingValues> = mutableStateOf(PaddingValues(top = 300.dp))
        private set

    var nextScreen: MainHostScreen? = null

    var isCityFocused = true;

    fun setCity(city: City) {
        selectedCity.value = city
        mapCameraState.value.position = CameraPosition(target = city.position, zoom = 8.0, padding = mapPadding.value)
    }

    suspend fun setPlace(place: Place) {
        isCityFocused = false
        selectedPlace.value = place
        mapCameraState.value.animateTo(
            finalPosition = CameraPosition(target = place.position, zoom = 18.0, tilt = 30.0, padding = mapPadding.value),
            duration = 1000.milliseconds
        )
    }

    suspend fun focusCity() {
        if (!isCityFocused) {
            selectedCity.value?.let {
                mapCameraState.value.animateTo(
                    finalPosition = CameraPosition(target = it.position, zoom = 8.0, padding = mapPadding.value),
                    duration = 1000.milliseconds
                )
            }
        }
        isCityFocused = true
    }

    fun setCategory(category: Category) {
        selectedCategory.value = category
    }

    suspend fun setExpandedView(expanded: Boolean) {
        mapPadding.value = if (expanded) {
            PaddingValues(top = 500.dp) // Increase padding to show more info
        } else {
            PaddingValues(top = 300.dp) // Default padding
        }
        // Re-center camera with new padding if a place is selected
        //selectedPlace.value?.let {
        //     mapCameraState.value.animateTo(finalPosition = CameraPosition(
        //         target = it.position,
        //         zoom = mapCameraState.value.position.zoom,
        //         tilt = mapCameraState.value.position.tilt,
        //         bearing = mapCameraState.value.position.bearing,
        //         padding = mapPadding.value
        //     ))
        //}
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

    suspend fun viewRandomPlace() {
        selectedCity.value?.let { city ->
            val place = city.places.random()
            setPlace(place)
            setExpandedView(true)
        }
    }

    fun tryChangeScreen(navHostController: NavHostController) {
        nextScreen?.let {
            navHostController.navigate(it.name)
            nextScreen = null
        }
    }
}
