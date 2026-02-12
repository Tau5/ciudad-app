package com.example.p4_ciudad_pabloalonsosergiorodriguez

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.p4_ciudad_pabloalonsosergiorodriguez.components.MainHostScreen
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.Category
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.City
import com.example.p4_ciudad_pabloalonsosergiorodriguez.data.Place
import org.maplibre.compose.camera.CameraPosition
import org.maplibre.compose.camera.CameraState
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

    var mapPadding: MutableState<Dp> = mutableStateOf(300.dp)
        private set

    var isHorizontal: MutableState<Boolean> = mutableStateOf(false)

    var searchQueryState: MutableState<String> = mutableStateOf("")
    var isSearching = mutableStateOf(false)

    var nextScreen: MainHostScreen? = null

    var isCityFocused = true;

    var currentMainHostScreen: MutableState<MainHostScreen> = mutableStateOf(MainHostScreen.SelectCity)
    var isExpanded = false;

    fun getMapPadding(): PaddingValues {
        return if (isHorizontal.value) {
            PaddingValues(start = mapPadding.value)
        } else {
            PaddingValues(top = mapPadding.value)
        }
    }

    suspend fun onOrientationUpdate() {
        setExpandedView(isExpanded)
        mapCameraState.value.position = mapCameraState.value.position.copy(padding = getMapPadding())
    }

    fun setCity(city: City) {
        selectedCity.value = city
        mapCameraState.value.position = CameraPosition(target = city.position, zoom = 10.0, padding = getMapPadding())
    }

    suspend fun setPlace(place: Place) {
        isCityFocused = false
        selectedPlace.value = place
        mapCameraState.value.animateTo(
            finalPosition = CameraPosition(target = place.position, zoom = 17.0, tilt = 30.0, padding = getMapPadding()),
            duration = 1000.milliseconds
        )
    }

    suspend fun focusCity() {
        if (!isCityFocused) {
            selectedCity.value?.let {
                mapCameraState.value.animateTo(
                    finalPosition = CameraPosition(target = it.position, zoom = 10.0, padding = getMapPadding()),
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
        isExpanded = expanded
        mapPadding.value = if (expanded) {
            500.dp
        } else {
            if (isHorizontal.value) {
                400.dp
            } else {
                300.dp
            }
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
            val filteredPlaces = if (isSearching.value) {
                city.places
                    .filter {
                        val name = stringResource(it.name)
                        name.contains(searchQueryState.value, true)
                    }
            } else {
                city.places
                    .filter { it.category == selectedCategory.value }
            }

            filteredPlaces.map{ Pair(stringResource(it.name), it) }
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

    fun cancelSearch() {
        searchQueryState.value = ""
        isSearching.value = false
    }
}
